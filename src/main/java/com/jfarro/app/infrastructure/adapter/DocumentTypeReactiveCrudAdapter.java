package com.jfarro.app.infrastructure.adapter;

import com.jfarro.app.domain.model.DocumentType;
import com.jfarro.app.domain.port.DocumentTypePersistencePort;
import com.jfarro.app.infrastructure.adapter.mapper.DocumentTypeDboMapper;
import com.jfarro.app.infrastructure.adapter.repository.DocumentTypeRepository;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.adapter.rxjava.RxJava2Adapter;

@Component
@AllArgsConstructor
@Slf4j
public class DocumentTypeReactiveCrudAdapter implements DocumentTypePersistencePort {

    private final DocumentTypeRepository documentTypeRepository;
    private final DocumentTypeDboMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public Observable<DocumentType> findAll() {
        return RxJava2Adapter.fluxToObservable(documentTypeRepository.findAll())
            .subscribeOn(Schedulers.io())
            .map(mapper::toDomain)
            .doOnSubscribe(disposable -> log.info("Getting document types by MySQL"))
            .doOnComplete(() -> log.info("document types obtained from MySQL correctly"))
            .doOnError(throwable -> log.error("Error getting document types from MySQL: {}", throwable.getMessage()));
    }

    @Override
    @Transactional(readOnly = true)
    public Observable<DocumentType> findById(Long documentTypeId) {
        return RxJava2Adapter.fluxToObservable(documentTypeRepository.findById(documentTypeId).flux())
            .subscribeOn(Schedulers.io())
            .map(mapper::toDomain)
            .doOnSubscribe(disposable -> log.info("Getting document type by MySQL"))
            .doOnComplete(() -> log.info("document type obtained from MySQL correctly"))
            .doOnError(throwable -> log.error("Error getting document type from MySQL: {}", throwable.getMessage()));
    }
}
