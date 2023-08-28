package com.jfarro.app.application.usecases;

import com.jfarro.app.domain.model.Person;
import com.jfarro.app.domain.ports.out.UpdatePersonCaseUse;
import com.jfarro.app.domain.ports.in.PersonRepository;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdatePersonCaseUseImpl implements UpdatePersonCaseUse {

    private final PersonRepository personRepository;

    @Override
    public Observable<Person> update(Person person) {
        return personRepository.save(person);
    }
}
