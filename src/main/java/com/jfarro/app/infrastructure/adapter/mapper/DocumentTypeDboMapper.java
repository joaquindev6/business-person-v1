package com.jfarro.app.infrastructure.adapter.mapper;

import com.jfarro.app.domain.model.DocumentType;
import com.jfarro.app.infrastructure.adapter.entity.DocumentTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class DocumentTypeDboMapper {

    public DocumentTypeEntity toEntity(DocumentType domain) {
        return DocumentTypeEntity.builder()
            .id(domain.getId())
            .code(domain.getCode())
            .longName(domain.getLongName())
            .shortName(domain.getShortName())
            .build();
    }

    public DocumentType toDomain(DocumentTypeEntity entity) {
        return DocumentType.builder()
            .id(entity.getId())
            .code(entity.getCode())
            .longName(entity.getLongName())
            .shortName(entity.getShortName())
            .build();
    }
}
