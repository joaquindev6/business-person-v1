package com.jfarro.app.domain.ports.out;

import com.jfarro.app.domain.model.DocumentTypeModel;
import io.reactivex.Observable;

public interface RetrievalDocumentTypeCaseUse {
    Observable<DocumentTypeModel> findAll();
    Observable<DocumentTypeModel> findById(Integer documentTypeId);
}
