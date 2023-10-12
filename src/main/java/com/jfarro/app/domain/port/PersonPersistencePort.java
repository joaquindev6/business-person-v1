package com.jfarro.app.domain.port;

import com.jfarro.app.domain.model.Person;
import io.reactivex.Completable;
import io.reactivex.Observable;

public interface PersonPersistencePort {
    Observable<Person> findAll();
    Observable<Person> findById(Long id);
    Observable<Person> save(Person person);
    Completable deleteById(Long id);
}
