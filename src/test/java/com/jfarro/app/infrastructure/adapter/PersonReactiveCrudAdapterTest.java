package com.jfarro.app.infrastructure.adapter;

import com.jfarro.app.domain.model.Person;
import com.jfarro.app.infrastructure.adapter.entity.PersonEntity;
import com.jfarro.app.infrastructure.adapter.mapper.PersonDboMapper;
import com.jfarro.app.infrastructure.adapter.repository.PersonRepository;
import com.jfarro.app.util.UtilTest;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonReactiveCrudAdapterTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonDboMapper mapper;

    @InjectMocks
    private PersonReactiveCrudAdapter adapter;

    private static final String URL_MOCK_PERSON = "mocks/person/person.json";
    private static final String URL_MOCK_PERSON_LIST = "mocks/person/personList.json";
    private static final String URL_MOCK_PERSON_ENTITY = "mocks/person/personEntity.json";
    private static final String URL_MOCK_PERSON_ENTITY_LIST = "mocks/person/personEntityList.json";

    @Test
    @DisplayName("return person list when find all is ok")
    void returnPersonListWhenFindAllIsOk() {

        List<PersonEntity> personEntityList = UtilTest
            .readJsonAsList(URL_MOCK_PERSON_ENTITY_LIST, PersonEntity.class);

        Person person = UtilTest
            .readJson(URL_MOCK_PERSON, Person.class);

        List<Person> personList = UtilTest
            .readJsonAsList(URL_MOCK_PERSON_LIST, Person.class);

        when(personRepository.findAll()).thenReturn(Flux.fromIterable(personEntityList));
        when(mapper.toDomain(any(PersonEntity.class))).thenReturn(person);

        TestObserver<Person> testObserver = adapter.findAll().test();

        testObserver.awaitTerminalEvent();
        testObserver.assertValues(personList.toArray(new Person[1]));
        testObserver.assertNoErrors();
        testObserver.assertComplete();
    }

    @Test
    @DisplayName("return person when find by id is ok")
    void returnPersonWhenFindByIdIsOk() {

        PersonEntity personEntity = UtilTest
            .readJson(URL_MOCK_PERSON_ENTITY, PersonEntity.class);

        Person person = UtilTest
            .readJson(URL_MOCK_PERSON, Person.class);

        when(personRepository.findById(anyLong())).thenReturn(Mono.just(personEntity));
        when(mapper.toDomain(any(PersonEntity.class))).thenReturn(person);

        TestObserver<Person> testObserver = adapter.findById(anyLong()).test();

        testObserver.awaitTerminalEvent();
        testObserver.assertValue(person);
        testObserver.assertNoErrors();
        testObserver.assertComplete();
    }

    @Test
    @DisplayName("return person when save is ok")
    void returnPersonWhenSaveIsOk() {

        PersonEntity personEntity = UtilTest
            .readJson(URL_MOCK_PERSON_ENTITY, PersonEntity.class);

        Person person = UtilTest
            .readJson(URL_MOCK_PERSON, Person.class);

        when(personRepository.save(any(PersonEntity.class))).thenReturn(Mono.just(personEntity));
        when(mapper.toEntity(any(Person.class))).thenReturn(personEntity);
        when(mapper.toDomain(any(PersonEntity.class))).thenReturn(person);

        TestObserver<Person> testObserver = adapter.save(person).test();

        testObserver.awaitTerminalEvent();
        testObserver.assertValue(person);
        testObserver.assertNoErrors();
        testObserver.assertComplete();
    }

    @Test
    @DisplayName("return successful when delete by id person is ok")
    void returnSuccessfulWhenDeleteByIdPersonIsOk()  {

        when(personRepository.deleteById(anyLong())).thenReturn(Mono.empty());

        TestObserver<Void> testObserver = adapter.deleteById(anyLong()).test();

        testObserver.awaitTerminalEvent();
        testObserver.assertNoErrors();
        testObserver.assertComplete();
    }
}