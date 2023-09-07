package com.jfarro.app.domain.ports.out;

import io.reactivex.Observable;

public interface RetrievalCaseUse<T> {
    Observable<T> findAll();
    Observable<T> findById(Integer id);
}
