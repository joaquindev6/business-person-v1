package com.jfarro.app.infrastructure.adapters;

import com.jfarro.app.domain.model.Person;
import com.jfarro.app.domain.ports.in.PersonRepository;
import com.jfarro.app.infrastructure.mapper.PersonMapper;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
@Slf4j
public class PersonRepositoryMysqlAdapter implements PersonRepository {

    private final PersonRepositoryMySQL personRepositoryMySQL;
    private final PersonMapper mapper;

    @Override
    public Observable<Person> findAll() {
        return RxJava2Adapter.fluxToObservable(personRepositoryMySQL.findAll())
                .subscribeOn(Schedulers.io())
                .map(mapper::personToDomain)
                .doOnSubscribe(disposable -> log.info("Getting persons by MySQL"))
                .doOnComplete(() -> log.info("Persons obtained from MySQL correctly"))
                .doOnError(throwable -> log.error("Error getting persons from MySQL: {}", throwable.getMessage()));
    }

    @Override
    public Observable<Person> findById(Integer id) {
        return RxJava2Adapter.fluxToObservable(Flux.from(personRepositoryMySQL.findById(id)))
                .subscribeOn(Schedulers.io())
                .map(mapper::personToDomain)
                .doOnSubscribe(disposable -> log.info("Getting person by MySQL"))
                .doOnComplete(() -> log.info("Person obtained from MySQL correctly"))
                .doOnError(throwable -> log.error("Error getting person from MySQL: {}", throwable.getMessage()));
    }

    @Override
    public Observable<Person> save(Person person) {
        return RxJava2Adapter.fluxToObservable(Flux.from(personRepositoryMySQL.save(mapper.personToEntity(person))))
                .subscribeOn(Schedulers.io())
                .map(mapper::personToDomain)
                .doOnSubscribe(disposable -> log.info("Save person in MySQL"))
                .doOnComplete(() -> log.info("Person save from MySQL correctly"))
                .doOnError(throwable -> log.error("Error save person from MySQL: {}", throwable.getMessage()));
    }

    @Override
    public Completable deleteById(Integer id) {
        return RxJava2Adapter.monoToCompletable(personRepositoryMySQL.deleteById(id))
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> log.info("Delete person in MySQL"))
                .doOnComplete(() -> log.info("Person delete from MySQL correctly"))
                .doOnError(throwable -> log.error("Error delete person from MySQL: {}", throwable.getMessage()));
    }
}