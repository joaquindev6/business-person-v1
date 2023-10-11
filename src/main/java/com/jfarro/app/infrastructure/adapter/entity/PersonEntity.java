package com.jfarro.app.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("id_document_type")
    private Long documentTypeId;

    @Column("document_number")
    private String documentNumber;

    @Column("phone_number")
    private String phoneNumber;

    @Column("email")
    private String email;
}
