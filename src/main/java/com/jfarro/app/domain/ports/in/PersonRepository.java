package com.jfarro.app.domain.ports.in;

import com.jfarro.app.domain.model.PersonModel;
import io.reactivex.Completable;
import io.reactivex.Observable;
import org.springframework.stereotype.Component;

@Component
public interface PersonRepository {
    Observable<PersonModel> findAll();
    Observable<PersonModel> findById(Integer id);
    Observable<PersonModel> save(PersonModel person);
    Completable deleteById(Integer id);
}
