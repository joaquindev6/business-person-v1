package com.jfarro.app.application.usecases;

import com.jfarro.app.domain.model.Person;
import com.jfarro.app.domain.ports.out.RetrievalPersonCaseUse;
import com.jfarro.app.domain.ports.in.PersonRepository;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RetrievalPersonCaseUseImpl implements RetrievalPersonCaseUse {

    private final PersonRepository personRepository;

    @Override
    public Observable<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Observable<Person> findById(Integer personId) {
        return personRepository.findById(personId);
    }
}
