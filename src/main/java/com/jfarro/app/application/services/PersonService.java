package com.jfarro.app.application.services;

import com.jfarro.app.domain.ports.out.CreatePersonCaseUse;
import com.jfarro.app.domain.ports.out.DeletePersonCaseUse;
import com.jfarro.app.domain.ports.out.RetrievalPersonCaseUse;
import com.jfarro.app.domain.ports.out.UpdatePersonCaseUse;
import org.springframework.stereotype.Component;

@Component
public interface PersonService extends CreatePersonCaseUse, UpdatePersonCaseUse, DeletePersonCaseUse, RetrievalPersonCaseUse {
}
