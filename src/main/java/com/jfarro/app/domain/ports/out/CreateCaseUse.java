package com.jfarro.app.domain.ports.out;

import com.jfarro.app.domain.model.PersonModel;
import io.reactivex.Observable;

public interface CreateCaseUse<T> {
    Observable<PersonModel> create(T t);
}
