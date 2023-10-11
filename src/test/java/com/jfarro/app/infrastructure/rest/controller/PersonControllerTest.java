package com.jfarro.app.infrastructure.rest.controller;

import com.jfarro.app.application.usecases.PersonService;
import com.jfarro.app.domain.model.dto.PersonDto;
import com.jfarro.app.util.UtilTest;
import io.reactivex.Completable;
import io.reactivex.Observable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@WebFluxTest(PersonController.class)
class PersonControllerTest {

    @MockBean
    private PersonService personService;

    @Autowired
    private WebTestClient webTestClient;

    private static final String URI = "/bs-person-v1/persons";
    private static final String URL_MOCK_PERSON = "mocks/person/person.json";
    private static final String URL_MOCK_PERSON_LIST = "mocks/person/personList.json";

    @Test
    @DisplayName("return successful when find all is ok")
    void returnSuccessfulWhenFindAllIsOk() {

        List<PersonDto> personDtoList = UtilTest
            .readJsonAsList(URL_MOCK_PERSON_LIST, PersonDto.class);

        when(personService.findAllPersons()).thenReturn(Observable.fromIterable(personDtoList));

        webTestClient.get()
            .uri(URI)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectStatus().isOk()
            .expectBodyList(PersonDto.class)
            .consumeWith(response -> {
                List<PersonDto> body = response.getResponseBody();
                assertNotNull(body);
                assertFalse(body.isEmpty());
            });
    }

    @Test
    @DisplayName("return successful when find by id is ok")
    void returnSuccessfulWhenFindByIdIsOk() {

        PersonDto personDto = UtilTest
            .readJson(URL_MOCK_PERSON, PersonDto.class);

        when(personService.findByIdPerson(anyLong())).thenReturn(Observable.just(personDto));

        webTestClient.get()
            .uri(URI.concat("/{id}"), 1L)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectStatus().isOk()
            .expectBody(PersonDto.class)
            .consumeWith(response -> {
                PersonDto body = response.getResponseBody();
                assertNotNull(body);
            });
    }

    @Test
    @DisplayName("return successful when create is ok")
    void returnSuccessfulWhenCreateIsOk() {

        PersonDto personDto = UtilTest
            .readJson(URL_MOCK_PERSON, PersonDto.class);

        when(personService.createPerson(any(PersonDto.class))).thenReturn(Observable.just(personDto));

        webTestClient.post()
            .uri(URI)
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(personDto)
            .exchange()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectStatus().isCreated()
            .expectBody(PersonDto.class)
            .consumeWith(response -> {
                PersonDto body = response.getResponseBody();
                assertNotNull(body);
            });
    }

    @Test
    @DisplayName("return successful when update is ok")
    void returnSuccessfulWhenUpdateIsOk() {

        PersonDto personDto = UtilTest
            .readJson(URL_MOCK_PERSON, PersonDto.class);

        when(personService.updatePerson(any(PersonDto.class), anyLong())).thenReturn(Observable.just(personDto));

        webTestClient.put()
            .uri(URI.concat("/{id}"), 1L)
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(personDto)
            .exchange()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectStatus().isOk()
            .expectBody(PersonDto.class)
            .consumeWith(response -> {
                PersonDto body = response.getResponseBody();
                assertNotNull(body);
            });
    }

    @Test
    @DisplayName("return successful when find by id is ok")
    void returnSuccessfulWhenDeleteByIdIsOk() {

        when(personService.deleteByIdPerson(anyLong())).thenReturn(Completable.complete());

        webTestClient.delete()
            .uri(URI.concat("/{id}"), 1L)
            .exchange()
            .expectStatus().isOk()
            .expectBody(Completable.class);
    }
}