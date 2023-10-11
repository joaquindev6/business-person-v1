package com.jfarro.app.application.service;

import com.jfarro.app.application.mapper.DocumentTypeMapper;
import com.jfarro.app.application.usecases.DocumentTypeService;
import com.jfarro.app.domain.model.dto.DocumentTypeDto;
import com.jfarro.app.domain.port.DocumentTypePersistencePort;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypePersistencePort documentTypePersistencePort;
    private final DocumentTypeMapper mapper;

    @Override
    public Observable<DocumentTypeDto> findAllDocumentTypes() {
        return documentTypePersistencePort.findAll()
            .map(mapper::toDto);
    }

    @Override
    public Observable<DocumentTypeDto> findByIdDocumentType(Long id) {
        return documentTypePersistencePort.findById(id)
            .map(mapper::toDto);
    }
}
