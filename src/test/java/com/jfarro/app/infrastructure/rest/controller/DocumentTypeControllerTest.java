package com.jfarro.app.infrastructure.rest.controller;

import com.jfarro.app.application.usecases.DocumentTypeService;
import com.jfarro.app.domain.model.dto.DocumentTypeDto;
import com.jfarro.app.util.UtilTest;
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
@WebFluxTest(DocumentTypeController.class)
class DocumentTypeControllerTest {

    @MockBean
    private DocumentTypeService service;

    @Autowired
    private WebTestClient webTestClient;

    private static final String URI = "/bs-person-v1/documentTypes";
    private static final String URL_MOCK_DOCUMENT_TYPE = "mocks/documentType/documentType.json";
    private static final String URL_MOCK_DOCUMENT_TYPE_LIST = "mocks/documentType/documentTypeList.json";

    @Test
    @DisplayName("return successful when find all is ok")
    void returnSuccessfulWhenFindAllIsOk() {

        List<DocumentTypeDto> documentTypeDtoList = UtilTest
            .readJsonAsList(URL_MOCK_DOCUMENT_TYPE_LIST, DocumentTypeDto.class);

        when(service.findAllDocumentTypes()).thenReturn(Observable.fromIterable(documentTypeDtoList));

        webTestClient.get()
            .uri(URI)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectStatus().isOk()
            .expectBodyList(DocumentTypeDto.class)
            .consumeWith(response -> {
                List<DocumentTypeDto> body = response.getResponseBody();
                assertNotNull(body);
                assertFalse(body.isEmpty());
            });
    }

    @Test
    @DisplayName("return successful when find by id is ok")
    void returnSuccessfulWhenFindByIdIsOk() {

        DocumentTypeDto documentTypeDto = UtilTest
            .readJson(URL_MOCK_DOCUMENT_TYPE, DocumentTypeDto.class);

        when(service.findByIdDocumentType(anyLong())).thenReturn(Observable.just(documentTypeDto));

        webTestClient.get()
            .uri(URI + "/{id}", 1L)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectStatus().isOk()
            .expectBody(DocumentTypeDto.class)
            .consumeWith(response -> {
                DocumentTypeDto body = response.getResponseBody();
                assertNotNull(body);
            });
    }
}