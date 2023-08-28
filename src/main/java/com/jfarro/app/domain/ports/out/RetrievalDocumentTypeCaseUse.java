package com.jfarro.app.domain.ports.out;

import com.jfarro.app.domain.model.DocumentType;
import io.reactivex.Observable;

public interface RetrievalDocumentTypeCaseUse {
    Observable<DocumentType> findAll();
    Observable<DocumentType> findById(Integer documentTypeId);
}
