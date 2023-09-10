package com.jfarro.app.infrastructure.adapters;

import com.jfarro.app.domain.entities.transactional.DocumentTypeEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepositoryMySQL extends ReactiveCrudRepository<DocumentTypeEntity, Integer> {
}
