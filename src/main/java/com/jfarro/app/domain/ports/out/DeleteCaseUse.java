package com.jfarro.app.domain.ports.out;

import io.reactivex.Completable;

public interface DeleteCaseUse {
    Completable delete(Integer id);
}
