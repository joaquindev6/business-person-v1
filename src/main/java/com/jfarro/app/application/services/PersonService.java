package com.jfarro.app.application.services;

import com.jfarro.app.domain.model.PersonModel;
import com.jfarro.app.domain.ports.out.CreateCaseUse;
import com.jfarro.app.domain.ports.out.DeleteCaseUse;
import com.jfarro.app.domain.ports.out.RetrievalCaseUse;
import com.jfarro.app.domain.ports.out.UpdateCaseUse;

public interface PersonService extends CreateCaseUse<PersonModel>, UpdateCaseUse<PersonModel>, DeleteCaseUse, RetrievalCaseUse<PersonModel> {
}
