package com.jfarro.app.infrastructure.mapper;

import com.jfarro.app.domain.model.DocumentType;
import com.jfarro.app.domain.model.Person;
import com.jfarro.app.domain.entities.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonEntity personToEntity(Person person) {
        return PersonEntity.builder()
                .personId(person.getPersonId())
                .names(person.getNames())
                .lastNames(person.getLastNames())
                .fullName(person.getFullName())
                .documentNumber(person.getDocumentNumber())
                .documentTypeId(person.getDocumentType().getDocumentTypeId())
                .phoneNumber(person.getPhoneNumber())
                .email(person.getEmail())
                .build();
    }

    public Person personToDomain(PersonEntity person) {
        return Person.builder()
                .personId(person.getPersonId())
                .names(person.getNames())
                .lastNames(person.getLastNames())
                .fullName(person.getFullName())
                .documentNumber(person.getDocumentNumber())
                .documentType(DocumentType.builder()
                        .documentTypeId(person.getDocumentTypeId())
                        .build())
                .phoneNumber(person.getPhoneNumber())
                .email(person.getEmail())
                .build();
    }
}
