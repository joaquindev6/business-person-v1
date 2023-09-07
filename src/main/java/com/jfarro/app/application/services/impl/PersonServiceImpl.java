package com.jfarro.app.application.services.impl;

import com.jfarro.app.application.services.DocumentTypeService;
import com.jfarro.app.application.services.PersonService;
import com.jfarro.app.domain.model.Person;
import com.jfarro.app.domain.ports.out.CreateCaseUse;
import com.jfarro.app.domain.ports.out.DeleteCaseUse;
import com.jfarro.app.domain.ports.out.RetrievalCaseUse;
import com.jfarro.app.domain.ports.out.UpdateCaseUse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final CreateCaseUse<Person> createCaseUse;
    private final UpdateCaseUse<Person> updateCaseUse;
    private final DeleteCaseUse deleteCaseUse;
    private final RetrievalCaseUse<Person> retrievalCaseUse;
    private final DocumentTypeService documentTypeService;

    @Override
    public Observable<Person> create(Person person) {
        return createCaseUse.create(person);
    }

    @Override
    public Completable delete(Integer personId) {
        return deleteCaseUse.delete(personId);
    }

    @Override
    public Observable<Person> findAll() {
        return retrievalCaseUse.findAll()
                .flatMap(person -> documentTypeService.findById(person.getDocumentType().getDocumentTypeId())
                        .map(documentType -> {
                            person.setDocumentType(documentType);
                            return person;
                        }));
    }

    @Override
    public Observable<Person> findById(Integer personId) {
        return retrievalCaseUse.findById(personId);
    }

    @Override
    public Observable<Person> update(Person person) {
        return updateCaseUse.update(person);
    }
}
