package com.jfarro.app.domain.ports.out;

import com.jfarro.app.domain.model.Person;
import io.reactivex.Observable;

public interface CreatePersonCaseUse {
    Observable<Person> create(Person person);
}
