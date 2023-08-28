package com.jfarro.app.domain.ports.out;

import io.reactivex.Completable;

public interface DeletePersonCaseUse {
    Completable delete(Integer personId);
}
