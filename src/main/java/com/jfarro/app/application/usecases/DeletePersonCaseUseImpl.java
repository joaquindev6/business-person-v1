package com.jfarro.app.application.usecases;

import com.jfarro.app.domain.ports.out.DeleteCaseUse;
import com.jfarro.app.domain.ports.in.PersonRepository;
import io.reactivex.Completable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeletePersonCaseUseImpl implements DeleteCaseUse {

    private final PersonRepository personRepository;

    @Override
    public Completable delete(Integer personId) {
        return personRepository.deleteById(personId);
    }
}
