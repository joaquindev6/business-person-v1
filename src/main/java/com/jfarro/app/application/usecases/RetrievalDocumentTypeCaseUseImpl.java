package com.jfarro.app.application.usecases;

import com.jfarro.app.domain.model.DocumentType;
import com.jfarro.app.domain.ports.out.RetrievalCaseUse;
import com.jfarro.app.domain.ports.in.DocumentTypeRepository;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RetrievalDocumentTypeCaseUseImpl implements RetrievalCaseUse<DocumentType> {

    private final DocumentTypeRepository documentTypeRepository;

    @Override
    public Observable<DocumentType> findAll() {
        return documentTypeRepository.findAll();
    }

    @Override
    public Observable<DocumentType> findById(Integer documentTypeId) {
        return documentTypeRepository.findById(documentTypeId);
    }
}
