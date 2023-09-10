package com.jfarro.app.infrastructure.adapters;

import com.jfarro.app.domain.entities.search.PersonSearchEntity;
import com.jfarro.app.domain.entities.transactional.PersonEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PersonRepositoryMySQL extends ReactiveCrudRepository<PersonEntity, Integer> {

    @Query("SELECT " +
            "p.id, p.id_document_type, d.code, d.long_name, d.short_name, p.document_number, p.email, p.phone_number " +
            "FROM persons AS p " +
            "INNER JOIN document_types AS d ON p.id_document_type = d.id;")
    Flux<PersonSearchEntity> findAllPersons();
}
