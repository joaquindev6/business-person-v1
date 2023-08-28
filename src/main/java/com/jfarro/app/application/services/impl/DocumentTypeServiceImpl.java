package com.jfarro.app.application.services.impl;

import com.jfarro.app.application.services.DocumentTypeService;
import com.jfarro.app.domain.model.DocumentType;
import com.jfarro.app.domain.ports.out.RetrievalDocumentTypeCaseUse;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final RetrievalDocumentTypeCaseUse retrievalDocumentTypeCaseUse;

    @Override
    public Observable<DocumentType> findAll() {
        return retrievalDocumentTypeCaseUse.findAll();
    }

    @Override
    public Observable<DocumentType> findById(Integer documentTypeId) {
        return retrievalDocumentTypeCaseUse.findById(documentTypeId);
    }
}
