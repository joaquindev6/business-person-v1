package com.jfarro.app.domain.ports.out;

import io.reactivex.Observable;

public interface UpdateCaseUse<T> {
    Observable<T> update(T t, Integer id);
}
