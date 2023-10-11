package com.jfarro.app.infrastructure.adapter;

import com.jfarro.app.domain.model.Person;
import com.jfarro.app.domain.port.PersonPersistencePort;
import com.jfarro.app.infrastructure.adapter.mapper.PersonDboMapper;
import com.jfarro.app.infrastructure.adapter.repository.PersonRepository;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
@Slf4j
public class PersonReactiveCrudAdapter implements PersonPersistencePort {

    private final PersonRepository personRepository;
    private final PersonDboMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public Observable<Person> findAll() {
        return RxJava2Adapter.fluxToObservable(personRepository.findAll())
            .subscribeOn(Schedulers.io())
            .map(mapper::toDomain)
            .doOnSubscribe(disposable -> log.info("Getting persons by MySQL"))
            .doOnComplete(() -> log.info("Persons obtained from MySQL correctly"))
            .doOnError(throwable -> log.error("Error getting persons from MySQL: {}", throwable.getMessage()));
    }

    @Override
    @Transactional(readOnly = true)
    public Observable<Person> findById(Long id) {
        return RxJava2Adapter.fluxToObservable(Flux.from(personRepository.findById(id)))
            .subscribeOn(Schedulers.io())
            .map(mapper::toDomain)
            .doOnSubscribe(disposable -> log.info("Getting person by MySQL"))
            .doOnComplete(() -> log.info("Person obtained from MySQL correctly"))
            .doOnError(throwable -> log.error("Error getting person from MySQL: {}", throwable.getMessage()));
    }

    @Override
    @Transactional
    public Observable<Person> save(Person person) {
        return RxJava2Adapter.fluxToObservable(Flux.from(personRepository.save(mapper.toEntity(person))))
            .subscribeOn(Schedulers.io())
            .map(mapper::toDomain)
            .doOnSubscribe(disposable -> log.info("Save person in MySQL"))
            .doOnComplete(() -> log.info("Person save from MySQL correctly"))
            .doOnError(throwable -> log.error("Error save person from MySQL: {}", throwable.getMessage()));
    }

    @Override
    @Transactional
    public Completable deleteById(Long id) {
        return RxJava2Adapter.monoToCompletable(personRepository.deleteById(id))
            .subscribeOn(Schedulers.io())
            .doOnSubscribe(disposable -> log.info("Delete person in MySQL"))
            .doOnComplete(() -> log.info("Person delete from MySQL correctly"))
            .doOnError(throwable -> log.error("Error delete person from MySQL: {}", throwable.getMessage()));
    }
}
