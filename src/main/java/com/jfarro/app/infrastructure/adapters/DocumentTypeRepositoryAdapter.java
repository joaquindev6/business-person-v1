package com.jfarro.app.infrastructure.adapters;

import com.jfarro.app.domain.model.DocumentType;
import com.jfarro.app.domain.ports.in.DocumentTypeRepository;
import com.jfarro.app.infrastructure.mapper.DocumentTypeMapper;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.adapter.rxjava.RxJava2Adapter;

@Component
@AllArgsConstructor
@Slf4j
public class DocumentTypeRepositoryAdapter implements DocumentTypeRepository {

    private final DocumentTypeRepositoryMySQL documentTypeRepositoryMySQL;
    private final DocumentTypeMapper documentTypeMapper;

    @Override
    public Observable<DocumentType> findAll() {
        return RxJava2Adapter.fluxToObservable(documentTypeRepositoryMySQL.findAll())
                .subscribeOn(Schedulers.io())
                .map(documentTypeMapper::documentTypeToDomain)
                .doOnSubscribe(disposable -> log.info("Getting document types by MySQL"))
                .doOnComplete(() -> log.info("document types obtained from MySQL correctly"))
                .doOnError(throwable -> log.error("Error getting document types from MySQL: {}", throwable.getMessage()));
    }

    @Override
    public Observable<DocumentType> findById(Integer documentTypeId) {
        return RxJava2Adapter.fluxToObservable(documentTypeRepositoryMySQL.findById(documentTypeId).flux())
                .subscribeOn(Schedulers.io())
                .map(documentTypeMapper::documentTypeToDomain)
                .doOnSubscribe(disposable -> log.info("Getting document type by MySQL"))
                .doOnComplete(() -> log.info("document type obtained from MySQL correctly"))
                .doOnError(throwable -> log.error("Error getting document type from MySQL: {}", throwable.getMessage()));
    }
}
