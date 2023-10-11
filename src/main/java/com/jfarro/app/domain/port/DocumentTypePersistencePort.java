package com.jfarro.app.domain.port;

import com.jfarro.app.domain.model.DocumentType;
import io.reactivex.Observable;

public interface DocumentTypePersistencePort {
    Observable<DocumentType> findAll();
    Observable<DocumentType> findById(Long documentTypeId);
}
