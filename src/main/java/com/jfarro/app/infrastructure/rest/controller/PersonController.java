package com.jfarro.app.infrastructure.rest.controller;

import com.jfarro.app.application.usecases.PersonService;
import com.jfarro.app.domain.model.dto.PersonDto;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bs-person-v1/persons")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public Maybe<ResponseEntity<Flowable<PersonDto>>> findAll() {
        return personService.findAllPersons()
            .subscribeOn(Schedulers.io())
            .toList()
            .map(Flowable::fromIterable)
            .toMaybe()
            .map(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public Maybe<ResponseEntity<PersonDto>> findById(@PathVariable("id") Long id) {
        return personService.findByIdPerson(id)
            .subscribeOn(Schedulers.io())
            .firstElement()
            .map(ResponseEntity::ok);
    }

    @PostMapping
    public Maybe<ResponseEntity<PersonDto>> create(@RequestBody PersonDto request) {
        return personService.createPerson(request)
            .subscribeOn(Schedulers.io())
            .firstElement()
            .map(person -> ResponseEntity.status(HttpStatus.CREATED).body(person));
    }

    @PutMapping("/{id}")
    public Maybe<ResponseEntity<PersonDto>> udpate(@RequestBody PersonDto request, @PathVariable("id") Long id) {
        return personService.updatePerson(request, id)
            .subscribeOn(Schedulers.io())
            .firstElement()
            .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public Maybe<ResponseEntity<Completable>> deleteById(@PathVariable("id") Long id) {
        return personService.deleteByIdPerson(id)
            .subscribeOn(Schedulers.io())
            .doOnComplete(ResponseEntity::ok)
            .toMaybe();
    }
}
