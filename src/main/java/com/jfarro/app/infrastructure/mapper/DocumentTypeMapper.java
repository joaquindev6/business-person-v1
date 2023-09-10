package com.jfarro.app.infrastructure.mapper;

import com.jfarro.app.domain.entities.transactional.DocumentTypeEntity;
import com.jfarro.app.domain.model.DocumentTypeModel;
import org.springframework.stereotype.Component;

@Component
public class DocumentTypeMapper {

    public DocumentTypeEntity documentTypeToEntity(DocumentTypeModel documentTypeModel) {
        return DocumentTypeEntity.builder()
                .documentTypeId(documentTypeModel.getDocumentTypeId())
                .code(documentTypeModel.getCode())
                .longName(documentTypeModel.getLongName())
                .shortName(documentTypeModel.getShortName())
                .build();
    }

    public DocumentTypeModel documentTypeToDomain(DocumentTypeEntity documentType) {
        return DocumentTypeModel.builder()
                .documentTypeId(documentType.getDocumentTypeId())
                .code(documentType.getCode())
                .longName(documentType.getLongName())
                .shortName(documentType.getShortName())
                .build();
    }
}
