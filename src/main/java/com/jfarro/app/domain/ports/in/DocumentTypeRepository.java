package com.jfarro.app.domain.ports.in;

import com.jfarro.app.domain.model.DocumentTypeModel;
import io.reactivex.Observable;
import org.springframework.stereotype.Component;

@Component
public interface DocumentTypeRepository {
    Observable<DocumentTypeModel> findAll();
    Observable<DocumentTypeModel> findById(Integer documentTypeId);
}
