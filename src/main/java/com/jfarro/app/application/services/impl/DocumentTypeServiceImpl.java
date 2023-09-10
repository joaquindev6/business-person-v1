package com.jfarro.app.application.services.impl;

import com.jfarro.app.application.services.DocumentTypeService;
import com.jfarro.app.domain.model.DocumentTypeModel;
import com.jfarro.app.domain.ports.out.RetrievalCaseUse;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final RetrievalCaseUse<DocumentTypeModel> retrievalDocumentTypeCaseUse;

    @Override
    public Observable<DocumentTypeModel> findAll() {
        return retrievalDocumentTypeCaseUse.findAll();
    }

    @Override
    public Observable<DocumentTypeModel> findById(Integer documentTypeId) {
        return retrievalDocumentTypeCaseUse.findById(documentTypeId);
    }
}
