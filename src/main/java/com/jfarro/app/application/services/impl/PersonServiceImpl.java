package com.jfarro.app.application.services.impl;

import com.jfarro.app.application.services.DocumentTypeService;
import com.jfarro.app.application.services.PersonService;
import com.jfarro.app.domain.model.Person;
import com.jfarro.app.domain.ports.out.CreatePersonCaseUse;
import com.jfarro.app.domain.ports.out.DeletePersonCaseUse;
import com.jfarro.app.domain.ports.out.RetrievalPersonCaseUse;
import com.jfarro.app.domain.ports.out.UpdatePersonCaseUse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final CreatePersonCaseUse createPersonCaseUse;
    private final UpdatePersonCaseUse updatePersonCaseUse;
    private final DeletePersonCaseUse deletePersonCaseUse;
    private final RetrievalPersonCaseUse retrievalPersonCaseUse;

    private final DocumentTypeService documentTypeService;

    @Override
    public Observable<Person> create(Person person) {
        return createPersonCaseUse.create(person);
    }

    @Override
    public Completable delete(Integer personId) {
        return deletePersonCaseUse.delete(personId);
    }

    @Override
    public Observable<Person> findAll() {
        return retrievalPersonCaseUse.findAll()
                .flatMap(person -> documentTypeService.findById(person.getDocumentType().getDocumentTypeId())
                        .map(documentType -> {
                            person.setDocumentType(documentType);
                            return person;
                        }));
    }

    @Override
    public Observable<Person> findById(Integer personId) {
        return retrievalPersonCaseUse.findById(personId);
    }

    @Override
    public Observable<Person> update(Person person) {
        return updatePersonCaseUse.update(person);
    }
}
