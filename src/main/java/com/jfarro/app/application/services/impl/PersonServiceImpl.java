package com.jfarro.app.application.services.impl;

import com.jfarro.app.application.services.DocumentTypeService;
import com.jfarro.app.application.services.PersonService;
import com.jfarro.app.domain.model.PersonModel;
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

    private final CreateCaseUse<PersonModel> createCaseUse;
    private final UpdateCaseUse<PersonModel> updateCaseUse;
    private final DeleteCaseUse deleteCaseUse;
    private final RetrievalCaseUse<PersonModel> retrievalCaseUse;
    private final DocumentTypeService documentTypeService;

    @Override
    public Observable<PersonModel> create(PersonModel person) {
        return createCaseUse.create(person)
                .flatMap(this::documentTypeMapper);
    }

    @Override
    public Completable delete(Integer personId) {
        return deleteCaseUse.delete(personId);
    }

    @Override
    public Observable<PersonModel> findAll() {
        return retrievalCaseUse.findAll();
    }

    @Override
    public Observable<PersonModel> findById(Integer personId) {
        return retrievalCaseUse.findById(personId);
    }

    @Override
    public Observable<PersonModel> update(PersonModel person, Integer id) {
        return updateCaseUse.update(person, id);
    }

    private Observable<PersonModel> documentTypeMapper(PersonModel person) {
        return documentTypeService.findById(person.getDocumentTypeModel().getDocumentTypeId())
            .map(documentType -> {
                person.setDocumentTypeModel(documentType);
                return person;
            });
    }
}
