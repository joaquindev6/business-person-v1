package com.jfarro.app.application.mapper;

import com.jfarro.app.domain.model.Person;
import com.jfarro.app.domain.model.dto.PersonDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PersonMapper {

    private final DocumentTypeMapper documentTypeMapper;

    public Person toDomain(PersonDto personDto) {
        return Person.builder()
            .id(personDto.getId())
            .documentType(documentTypeMapper.toDomain(personDto.getDocumentType()))
            .documentNumber(personDto.getDocumentNumber())
            .phoneNumber(personDto.getPhoneNumber())
            .email(personDto.getEmail())
            .build();
    }

    public PersonDto toDto(Person domain) {
        return PersonDto.builder()
            .id(domain.getId())
            .documentType(documentTypeMapper.toDto(domain.getDocumentType()))
            .documentNumber(domain.getDocumentNumber())
            .phoneNumber(domain.getPhoneNumber())
            .email(domain.getEmail())
            .build();
    }
}
