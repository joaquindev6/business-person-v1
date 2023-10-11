package com.jfarro.app.application.usecases;

import com.jfarro.app.domain.model.dto.PersonDto;
import io.reactivex.Completable;
import io.reactivex.Observable;

public interface PersonService {
    Observable<PersonDto> findAllPersons();
    Observable<PersonDto> findByIdPerson(Long id);
    Observable<PersonDto> createPerson(PersonDto personDto);
    Observable<PersonDto> updatePerson(PersonDto personDto, Long id);
    Completable deleteByIdPerson(Long id);
}
