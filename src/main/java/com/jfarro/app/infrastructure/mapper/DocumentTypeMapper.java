package com.jfarro.app.infrastructure.mapper;

import com.jfarro.app.domain.entities.DocumentTypeEntity;
import com.jfarro.app.domain.model.DocumentType;
import org.springframework.stereotype.Component;

@Component
public class DocumentTypeMapper {

    public DocumentTypeEntity documentTypeToEntity(DocumentType documentType) {
        return DocumentTypeEntity.builder()
                .documentTypeId(documentType.getDocumentTypeId())
                .code(documentType.getCode())
                .name(documentType.getName())
                .nomenclature(documentType.getNomenclature())
                .build();
    }

    public DocumentType documentTypeToDomain(DocumentTypeEntity documentType) {
        return DocumentType.builder()
                .documentTypeId(documentType.getDocumentTypeId())
                .code(documentType.getCode())
                .name(documentType.getName())
                .nomenclature(documentType.getNomenclature())
                .build();
    }
}
