package com.jfarro.app.infrastructure.mapper;

import com.jfarro.app.domain.model.DocumentTypeModel;
import com.jfarro.app.domain.model.PersonModel;
import com.jfarro.app.domain.entities.transactional.PersonEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PersonMapper {

    public PersonEntity personDomainToEntity(PersonModel person) {
        return PersonEntity.builder()
            .personId(person.getPersonId())
            .documentNumber(person.getDocumentNumber())
            .documentTypeId(person.getDocumentTypeModel().getDocumentTypeId())
            .phoneNumber(person.getPhoneNumber())
            .email(person.getEmail())
            .build();
    }

    public PersonModel personEntityToDomain(PersonEntity person) {
        return PersonModel.builder()
            .personId(person.getPersonId())
            .documentNumber(person.getDocumentNumber())
            .documentTypeModel(DocumentTypeModel.builder()
                .documentTypeId(person.getDocumentTypeId())
                .build())
            .phoneNumber(person.getPhoneNumber())
            .email(person.getEmail())
            .build();
    }
}
