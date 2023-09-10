package com.jfarro.app.infrastructure.controllers;

import com.jfarro.app.application.services.PersonService;
import com.jfarro.app.domain.model.PersonModel;
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
    public Maybe<ResponseEntity<Flowable<PersonModel>>> findAll() {
        return personService.findAll()
            .subscribeOn(Schedulers.io())
            .toList()
            .map(Flowable::fromIterable)
            .toMaybe()
            .map(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public Maybe<ResponseEntity<PersonModel>> findById(@PathVariable("id") Integer id) {
        return personService.findById(id)
            .subscribeOn(Schedulers.io())
            .firstElement()
            .map(ResponseEntity::ok);
    }

    @PostMapping
    public Maybe<ResponseEntity<PersonModel>> create(@RequestBody PersonModel personRequest) {
        return personService.create(personRequest)
            .subscribeOn(Schedulers.io())
            .firstElement()
            .map(person -> ResponseEntity.status(HttpStatus.CREATED).body(person));
    }

    @PutMapping("/{id}")
    public Maybe<ResponseEntity<PersonModel>> udpate(@RequestBody PersonModel personRequest, @PathVariable("id") Integer id) {
        return personService.update(personRequest, id)
            .subscribeOn(Schedulers.io())
            .firstElement()
            .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public Maybe<ResponseEntity<Completable>> deleteById(@PathVariable("id") Integer id) {
        return personService.delete(id)
            .subscribeOn(Schedulers.io())
            .doOnComplete(ResponseEntity::ok)
            .toMaybe();
    }
}
