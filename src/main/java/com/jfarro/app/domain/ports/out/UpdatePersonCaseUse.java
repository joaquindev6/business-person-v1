package com.jfarro.app.domain.ports.out;

import com.jfarro.app.domain.model.Person;
import io.reactivex.Observable;

public interface UpdatePersonCaseUse {
    Observable<Person> update(Person person);
}
