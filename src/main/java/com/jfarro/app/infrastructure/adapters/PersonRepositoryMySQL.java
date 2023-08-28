package com.jfarro.app.infrastructure.adapters;

import com.jfarro.app.domain.entities.PersonEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositoryMySQL extends ReactiveCrudRepository<PersonEntity, Integer> {
}
