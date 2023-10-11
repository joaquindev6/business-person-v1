package com.jfarro.app.infrastructure.adapter;

import com.jfarro.app.domain.model.DocumentType;
import com.jfarro.app.infrastructure.adapter.entity.DocumentTypeEntity;
import com.jfarro.app.infrastructure.adapter.mapper.DocumentTypeDboMapper;
import com.jfarro.app.infrastructure.adapter.repository.DocumentTypeRepository;
import com.jfarro.app.util.UtilTest;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class DocumentTypeReactiveCrudAdapterTest {

    @Mock
    private DocumentTypeRepository documentTypeRepository;

    @Mock
    private DocumentTypeDboMapper mapper;

    @InjectMocks
    private DocumentTypeReactiveCrudAdapter adapter;

    private static final String URL_MOCK_DOCUMENT_TYPE = "mocks/documentType/documentType.json";
    private static final String URL_MOCK_DOCUMENT_TYPE_LIST = "mocks/documentType/documentTypeList.json";
    private static final String URL_MOCK_DOCUMENT_TYPE_ENTITY = "mocks/documentType/documentTypeEntity.json";
    private static final String URL_MOCK_DOCUMENT_TYPE_ENTITY_LIST = "mocks/documentType/documentTypeEntityList.json";

    @Test
    @DisplayName("return document type list when find all is ok")
    void returnDocumentTypeListWhenFindAllIsOk() {

        List<DocumentTypeEntity> documentTypeEntityList = UtilTest
            .readJsonAsList(URL_MOCK_DOCUMENT_TYPE_ENTITY_LIST, DocumentTypeEntity.class);

        DocumentType documentType = UtilTest
            .readJson(URL_MOCK_DOCUMENT_TYPE, DocumentType.class);

        List<DocumentType> documentTypeList = UtilTest
            .readJsonAsList(URL_MOCK_DOCUMENT_TYPE_LIST, DocumentType.class);

        when(documentTypeRepository.findAll()).thenReturn(Flux.fromIterable(documentTypeEntityList));
        when(mapper.toDomain(any(DocumentTypeEntity.class))).thenReturn(documentType);

        TestObserver<DocumentType> testObserver = adapter.findAll().test();

        testObserver.awaitTerminalEvent();
        testObserver.assertValues(documentTypeList.toArray(new DocumentType[1]));
        testObserver.assertNoErrors();
        testObserver.assertComplete();
    }

    @Test
    @DisplayName("return document type when find by id is ok")
    void returnDocumentTypeWhenFindByIdIsOk() {

        DocumentTypeEntity documentTypeEntity = UtilTest
            .readJson(URL_MOCK_DOCUMENT_TYPE_ENTITY, DocumentTypeEntity.class);

        DocumentType documentType = UtilTest
            .readJson(URL_MOCK_DOCUMENT_TYPE, DocumentType.class);

        when(documentTypeRepository.findById(anyLong())).thenReturn(Mono.just(documentTypeEntity));
        when(mapper.toDomain(any(DocumentTypeEntity.class))).thenReturn(documentType);

        TestObserver<DocumentType> testObserver = adapter.findById(anyLong()).test();

        testObserver.awaitTerminalEvent();
        testObserver.assertValue(documentType);
        testObserver.assertNoErrors();
        testObserver.assertComplete();
    }
}