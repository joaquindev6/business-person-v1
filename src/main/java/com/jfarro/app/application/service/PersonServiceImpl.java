package com.jfarro.app.application.service;

import com.jfarro.app.application.mapper.DocumentTypeMapper;
import com.jfarro.app.application.mapper.PersonMapper;
import com.jfarro.app.application.usecases.PersonService;
import com.jfarro.app.domain.model.dto.PersonDto;
import com.jfarro.app.domain.port.DocumentTypePersistencePort;
import com.jfarro.app.domain.port.PersonPersistencePort;
import io.reactivex.Completable;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonPersistencePort personPersistencePort;
    private final DocumentTypePersistencePort documentTypePersistencePort;
    private final PersonMapper personMapper;
    private final DocumentTypeMapper documentTypeMapper;

    @Override
    public Observable<PersonDto> findAllPersons() {
        return personPersistencePort.findAll()
            .flatMap(person -> addDocumentType(personMapper.toDto(person)));
    }

    @Override
    public Observable<PersonDto> findByIdPerson(Long id) {
        return personPersistencePort.findById(id)
            .flatMap(person -> addDocumentType(personMapper.toDto(person)));
    }

    @Override
    public Observable<PersonDto> createPerson(PersonDto personDto) {
        return personPersistencePort.save(personMapper.toDomain(personDto))
            .map(personMapper::toDto);
    }

    @Override
    public Observable<PersonDto> updatePerson(PersonDto personDto, Long id) {
        return personPersistencePort.findById(id)
            .map(personMapper::toDto)
            .flatMap(personDtoUpdate -> {
                personDtoUpdate.setId(id);
                personDtoUpdate.setDocumentType(personDto.getDocumentType());
                personDtoUpdate.setDocumentNumber(personDto.getDocumentNumber());
                personDtoUpdate.setPhoneNumber(personDto.getPhoneNumber());
                personDtoUpdate.setEmail(personDto.getEmail());
                return personPersistencePort.save(personMapper.toDomain(personDtoUpdate));
            })
            .map(personMapper::toDto)
            .flatMap(this::addDocumentType);
    }

    @Override
    public Completable deleteByIdPerson(Long id) {
        return personPersistencePort.deleteById(id);
    }

    private Observable<PersonDto> addDocumentType(PersonDto personDto) {
        return documentTypePersistencePort.findById(personDto.getDocumentType().getId())
            .map(documentType -> {
                personDto.setDocumentType(documentTypeMapper.toDto(documentType));
                return personDto;
            });
    }
}
