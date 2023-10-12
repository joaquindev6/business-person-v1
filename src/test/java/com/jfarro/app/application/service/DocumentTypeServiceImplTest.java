package com.jfarro.app.application.service;

import com.jfarro.app.application.mapper.DocumentTypeMapper;
import com.jfarro.app.domain.model.DocumentType;
import com.jfarro.app.domain.model.dto.DocumentTypeDto;
import com.jfarro.app.domain.port.DocumentTypePersistencePort;
import com.jfarro.app.util.UtilTest;
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
class DocumentTypeServiceImplTest {

    @Mock
    private DocumentTypePersistencePort documentTypePersistencePort;

    @Mock
    private DocumentTypeMapper mapper;

    @InjectMocks
    private DocumentTypeServiceImpl documentTypeService;

    private static final String URL_MOCK_DOCUMENT_TYPE = "mocks/documentType/documentType.json";
    private static final String URL_MOCK_DOCUMENT_TYPE_LIST = "mocks/documentType/documentTypeList.json";

    @Test
    @DisplayName("return document type list when find all is ok")
    void returnDocumentTypeListWhenFindAllIsOk() {

        List<DocumentType> documentTypeList = UtilTest
            .readJsonAsList(URL_MOCK_DOCUMENT_TYPE_LIST, DocumentType.class);

        DocumentTypeDto documentTypeDto = UtilTest
            .readJson(URL_MOCK_DOCUMENT_TYPE, DocumentTypeDto.class);

        List<DocumentTypeDto> documentTypeDtoList = UtilTest
            .readJsonAsList(URL_MOCK_DOCUMENT_TYPE_LIST, DocumentTypeDto.class);

        when(documentTypePersistencePort.findAll()).thenReturn(Observable.fromIterable(documentTypeList));
        when(mapper.toDto(any(DocumentType.class))).thenReturn(documentTypeDto);

        documentTypeService.findAllDocumentTypes()
            .test()
            .assertValues(documentTypeDtoList.toArray(new DocumentTypeDto[1]))
            .assertNoErrors()
            .assertComplete();
    }

    @Test
    @DisplayName("return document type when find by id is ok")
    void returnDocumentTypeWhenFindByIdIsOk() {

        DocumentType documentType = UtilTest
            .readJson(URL_MOCK_DOCUMENT_TYPE, DocumentType.class);

        DocumentTypeDto documentTypeDto = UtilTest
            .readJson(URL_MOCK_DOCUMENT_TYPE, DocumentTypeDto.class);

        when(documentTypePersistencePort.findById(anyLong())).thenReturn(Observable.just(documentType));
        when(mapper.toDto(any(DocumentType.class))).thenReturn(documentTypeDto);

        documentTypeService.findByIdDocumentType(anyLong())
            .test()
            .assertValue(documentTypeDto)
            .assertNoErrors()
            .assertComplete();
    }
}