package com.jfarro.app.application.usecases;

import com.jfarro.app.domain.model.Person;
import com.jfarro.app.domain.ports.out.CreatePersonCaseUse;
import com.jfarro.app.domain.ports.in.PersonRepository;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreatePersonCaseUseImpl implements CreatePersonCaseUse {

    private final PersonRepository personRepository;

    @Override
    public Observable<Person> create(Person person) {
        return personRepository.save(person);
    }
}
