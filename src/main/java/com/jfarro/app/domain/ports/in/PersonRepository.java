package com.jfarro.app.domain.ports.in;

import com.jfarro.app.domain.model.Person;
import io.reactivex.Completable;
import io.reactivex.Observable;
import org.springframework.stereotype.Component;

@Component
public interface PersonRepository {
    Observable<Person> findAll();
    Observable<Person> findById(Integer id);
    Observable<Person> save(Person person);
    Completable deleteById(Integer id);
}
