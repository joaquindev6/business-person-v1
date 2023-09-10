package com.jfarro.app.application.usecases;

import com.jfarro.app.domain.model.DocumentTypeModel;
import com.jfarro.app.domain.ports.out.RetrievalCaseUse;
import com.jfarro.app.domain.ports.in.DocumentTypeRepository;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RetrievalDocumentTypeCaseUseImpl implements RetrievalCaseUse<DocumentTypeModel> {

    private final DocumentTypeRepository documentTypeRepository;

    @Override
    public Observable<DocumentTypeModel> findAll() {
        return documentTypeRepository.findAll();
    }

    @Override
    public Observable<DocumentTypeModel> findById(Integer documentTypeId) {
        return documentTypeRepository.findById(documentTypeId);
    }
}
