package com.jfarro.app.infrastructure.controllers;

import com.jfarro.app.application.services.PersonService;
import com.jfarro.app.domain.model.Person;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bs-person-v1/persons")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public Maybe<ResponseEntity<Flowable<Person>>> findAll() {
        return personService.findAll()
                .subscribeOn(Schedulers.io())
                .toList()
                .map(Flowable::fromIterable)
                .toMaybe()
                .map(ResponseEntity::ok);
    }
}
