package com.jfarro.app.infrastructure.adapter.mapper;

import com.jfarro.app.domain.model.DocumentType;
import com.jfarro.app.domain.model.Person;
import com.jfarro.app.infrastructure.adapter.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonDboMapper {

    public PersonEntity toEntity(Person domain) {
        return PersonEntity.builder()
            .id(domain.getId())
            .documentTypeId(domain.getDocumentType().getId())
            .documentNumber(domain.getDocumentNumber())
            .phoneNumber(domain.getPhoneNumber())
            .email(domain.getEmail())
            .build();
    }

    public Person toDomain(PersonEntity entity) {
        return Person.builder()
            .id(entity.getId())
            .documentType(DocumentType.builder()
                .id(entity.getDocumentTypeId())
                .build())
            .documentNumber(entity.getDocumentNumber())
            .phoneNumber(entity.getPhoneNumber())
            .email(entity.getEmail())
            .build();
    }
}
