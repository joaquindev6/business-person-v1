package com.jfarro.app.application.mapper;

import com.jfarro.app.domain.model.DocumentType;
import com.jfarro.app.domain.model.dto.DocumentTypeDto;
import org.springframework.stereotype.Component;

@Component
public class DocumentTypeMapper {

    public DocumentType toDomain(DocumentTypeDto documentTypeDto) {
        return DocumentType.builder()
            .id(documentTypeDto.getId())
            .code(documentTypeDto.getCode())
            .longName(documentTypeDto.getLongName())
            .shortName(documentTypeDto.getShortName())
            .build();
    }

    public DocumentTypeDto toDto(DocumentType domain) {
        return DocumentTypeDto.builder()
            .id(domain.getId())
            .code(domain.getCode())
            .longName(domain.getLongName())
            .shortName(domain.getShortName())
            .build();
    }
}
