package com.jfarro.app.infrastructure.adapter.repository;

import com.jfarro.app.infrastructure.adapter.entity.DocumentTypeEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends ReactiveCrudRepository<DocumentTypeEntity, Long> {
}
