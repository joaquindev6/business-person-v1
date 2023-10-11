package com.jfarro.app.application.usecases;

import com.jfarro.app.domain.model.dto.DocumentTypeDto;
import io.reactivex.Observable;

public interface DocumentTypeService {
    Observable<DocumentTypeDto> findAllDocumentTypes();
    Observable<DocumentTypeDto> findByIdDocumentType(Long id);
}
