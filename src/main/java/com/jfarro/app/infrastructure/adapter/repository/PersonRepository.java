package com.jfarro.app.infrastructure.adapter.repository;

import com.jfarro.app.infrastructure.adapter.entity.PersonEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ReactiveCrudRepository<PersonEntity, Long> {
}
