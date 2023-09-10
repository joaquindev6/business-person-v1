package com.jfarro.app.application.usecases;

import com.jfarro.app.domain.model.PersonModel;
import com.jfarro.app.domain.ports.out.UpdateCaseUse;
import com.jfarro.app.domain.ports.in.PersonRepository;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdatePersonCaseUseImpl implements UpdateCaseUse<PersonModel> {

    private final PersonRepository personRepository;

    @Override
    public Observable<PersonModel> update(PersonModel person, Integer id) {
        return personRepository.findById(id)
            .map(personModel -> {
                personModel.setDocumentNumber(person.getDocumentNumber());
                personModel.setEmail(person.getEmail());
                personModel.setPhoneNumber(person.getPhoneNumber());
                personModel.setDocumentTypeModel(personModel.getDocumentTypeModel());
                return personModel;
            }).flatMap(personRepository::save);
    }
}
