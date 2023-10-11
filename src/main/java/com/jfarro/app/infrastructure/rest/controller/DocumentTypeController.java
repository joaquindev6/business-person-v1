package com.jfarro.app.infrastructure.rest.controller;

import com.jfarro.app.application.usecases.DocumentTypeService;
import com.jfarro.app.domain.model.dto.DocumentTypeDto;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bs-person-v1/documentTypes")
@AllArgsConstructor
public class DocumentTypeController {

    private final DocumentTypeService documentTypeService;

    @GetMapping
    public Maybe<ResponseEntity<Flowable<DocumentTypeDto>>> findAll() {
        return documentTypeService.findAllDocumentTypes()
            .subscribeOn(Schedulers.io())
            .toList()
            .map(Flowable::fromIterable)
            .toMaybe()
            .map(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public Maybe<ResponseEntity<DocumentTypeDto>> findById(@PathVariable("id") Long id) {
        return documentTypeService.findByIdDocumentType(id)
            .subscribeOn(Schedulers.io())
            .firstElement()
            .map(ResponseEntity::ok);
    }
}
