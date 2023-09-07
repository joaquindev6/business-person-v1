package com.jfarro.app.application.usecases;

import com.jfarro.app.domain.model.Person;
import com.jfarro.app.domain.ports.out.UpdateCaseUse;
import com.jfarro.app.domain.ports.in.PersonRepository;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdatePersonCaseUseImpl implements UpdateCaseUse<Person> {

    private final PersonRepository personRepository;

    @Override
    public Observable<Person> update(Person person) {
        return personRepository.save(person);
    }
}
