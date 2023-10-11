package com.jfarro.app.application.service;

import com.jfarro.app.application.mapper.DocumentTypeMapper;
import com.jfarro.app.application.mapper.PersonMapper;
import com.jfarro.app.domain.model.DocumentType;
import com.jfarro.app.domain.model.Person;
import com.jfarro.app.domain.model.dto.DocumentTypeDto;
import com.jfarro.app.domain.model.dto.PersonDto;
import com.jfarro.app.domain.port.DocumentTypePersistencePort;
import com.jfarro.app.domain.port.PersonPersistencePort;
import com.jfarro.app.util.UtilTest;
import io.reactivex.Completable;
import io.reactivex.Observable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonPersistencePort personPersistencePort;

    @Mock
    private DocumentTypePersistencePort documentTypePersistencePort;

    @Mock
    private PersonMapper personMapper;

    @Mock
    private DocumentTypeMapper documentTypeMapper;

    @InjectMocks
    private PersonServiceImpl personService;

    private static final String URL_MOCK_PERSON = "mocks/person/person.json";
    private static final String URL_MOCK_PERSON_LIST = "mocks/person/personList.json";
    private static final String URL_MOCK_DOCUMENT_TYPE = "mocks/documentType/documentType.json";

    @Test
    @DisplayName("return person list when find all is ok")
    void returnPersonListWhenFindAllIsOk() {

        List<Person> personList = UtilTest
            .readJsonAsList(URL_MOCK_PERSON_LIST, Person.class);

        List<PersonDto> personDtoList = UtilTest
            .readJsonAsList(URL_MOCK_PERSON_LIST, PersonDto.class);

        PersonDto personDto = UtilTest
            .readJson(URL_MOCK_PERSON, PersonDto.class);

        DocumentType documentType = UtilTest
            .readJson(URL_MOCK_DOCUMENT_TYPE, DocumentType.class);

        DocumentTypeDto documentTypeDto = UtilTest
            .readJson(URL_MOCK_DOCUMENT_TYPE, DocumentTypeDto.class);

        when(personPersistencePort.findAll()).thenReturn(Observable.fromIterable(personList));
        when(personMapper.toDto(any(Person.class))).thenReturn(personDto);
        when(documentTypePersistencePort.findById(anyLong())).thenReturn(Observable.just(documentType));
        when(documentTypeMapper.toDto(any(DocumentType.class))).thenReturn(documentTypeDto);

        personService.findAllPersons()
            .test()
            .assertValues(personDtoList.toArray(new PersonDto[1]))
            .assertNoErrors()
            .assertComplete();
    }

    @Test
    @DisplayName("return person when find by id is ok")
    void returnPersonWhenFindByIdIsOk() {

        Person person = UtilTest
            .readJson(URL_MOCK_PERSON, Person.class);

        PersonDto personDto = UtilTest
            .readJson(URL_MOCK_PERSON, PersonDto.class);

        DocumentType documentType = UtilTest
            .readJson(URL_MOCK_DOCUMENT_TYPE, DocumentType.class);

        DocumentTypeDto documentTypeDto = UtilTest
            .readJson(URL_MOCK_DOCUMENT_TYPE, DocumentTypeDto.class);

        when(personPersistencePort.findById(anyLong())).thenReturn(Observable.just(person));
        when(personMapper.toDto(any(Person.class))).thenReturn(personDto);
        when(documentTypePersistencePort.findById(anyLong())).thenReturn(Observable.just(documentType));
        when(documentTypeMapper.toDto(any(DocumentType.class))).thenReturn(documentTypeDto);

        personService.findByIdPerson(anyLong())
            .test()
            .assertValue(personDto)
            .assertNoErrors()
            .assertComplete();
    }

    @Test
    @DisplayName("return person when create is ok")
    void returnPersonWhenCreateIsOk() {

        Person person = UtilTest
            .readJson(URL_MOCK_PERSON, Person.class);

        PersonDto personDto = UtilTest
            .readJson(URL_MOCK_PERSON, PersonDto.class);

        when(personPersistencePort.save(any(Person.class))).thenReturn(Observable.just(person));
        when(personMapper.toDomain(any(PersonDto.class))).thenReturn(person);
        when(personMapper.toDto(any(Person.class))).thenReturn(personDto);

        personService.createPerson(personDto)
            .test()
            .assertValue(personDto)
            .assertNoErrors()
            .assertComplete();
    }

    @Test
    @DisplayName("return person when update is ok")
    void returnPersonWhenUpdateIsOk() {

        Person person = UtilTest
            .readJson(URL_MOCK_PERSON, Person.class);

        PersonDto personDto = UtilTest
            .readJson(URL_MOCK_PERSON, PersonDto.class);

        when(personPersistencePort.findById(anyLong())).thenReturn(Observable.just(person));
        when(personMapper.toDto(any(Person.class))).thenReturn(personDto);
        when(personPersistencePort.save(any(Person.class))).thenReturn(Observable.just(person));
        when(personMapper.toDomain(any(PersonDto.class))).thenReturn(person);

        personService.updatePerson(personDto, 1L)
            .test()
            .assertValue(personDto)
            .assertNoErrors()
            .assertComplete();
    }

    @Test
    @DisplayName("return successful when delete by id person is ok")
    void returnSuccessfulWhenDeleteByIdPersonIsOk() {

        when(personPersistencePort.deleteById(anyLong())).thenReturn(Completable.complete());

        personService.deleteByIdPerson(anyLong())
            .test()
            .assertNoErrors()
            .assertComplete();
    }
}