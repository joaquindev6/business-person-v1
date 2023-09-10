package com.jfarro.app.infrastructure.controllers;

import com.jfarro.app.application.services.DocumentTypeService;
import com.jfarro.app.domain.model.DocumentTypeModel;
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
    public Maybe<ResponseEntity<Flowable<DocumentTypeModel>>> findAll() {
        return documentTypeService.findAll()
            .subscribeOn(Schedulers.io())
            .toList()
            .map(Flowable::fromIterable)
            .toMaybe()
            .map(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public Maybe<ResponseEntity<DocumentTypeModel>> findById(@PathVariable("id") Integer id) {
        return documentTypeService.findById(id)
            .subscribeOn(Schedulers.io())
            .firstElement()
            .map(ResponseEntity::ok);
    }
}
