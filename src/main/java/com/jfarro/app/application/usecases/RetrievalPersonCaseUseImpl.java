package com.jfarro.app.application.usecases;

import com.jfarro.app.domain.model.PersonModel;
import com.jfarro.app.domain.ports.out.RetrievalCaseUse;
import com.jfarro.app.domain.ports.in.PersonRepository;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RetrievalPersonCaseUseImpl implements RetrievalCaseUse<PersonModel> {

    private final PersonRepository personRepository;

    @Override
    public Observable<PersonModel> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Observable<PersonModel> findById(Integer personId) {
        return personRepository.findById(personId);
    }
}
