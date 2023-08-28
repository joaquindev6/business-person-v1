package com.jfarro.app.domain.ports.in;

import com.jfarro.app.domain.model.DocumentType;
import io.reactivex.Observable;
import org.springframework.stereotype.Component;

@Component
public interface DocumentTypeRepository {
    Observable<DocumentType> findAll();
    Observable<DocumentType> findById(Integer documentTypeId);
}
