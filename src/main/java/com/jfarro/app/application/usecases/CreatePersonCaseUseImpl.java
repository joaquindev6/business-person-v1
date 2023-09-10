package com.jfarro.app.application.usecases;

import com.jfarro.app.domain.model.PersonModel;
import com.jfarro.app.domain.ports.out.CreateCaseUse;
import com.jfarro.app.domain.ports.in.PersonRepository;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreatePersonCaseUseImpl implements CreateCaseUse<PersonModel> {

    private final PersonRepository personRepository;

    @Override
    public Observable<PersonModel> create(PersonModel person) {
        return personRepository.save(person);
    }
}
