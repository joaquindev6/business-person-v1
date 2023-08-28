package com.jfarro.app.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonEntity {

    @Id
    @Column("id")
    private Integer personId;

    @Column("names")
    private String names;

    @Column("last_names")
    private String lastNames;

    @Column("full_name")
    private String fullName;

    @Column( "document_number")
    private String documentNumber;

    @Column("phone_number")
    private String phoneNumber;

    @Column("email")
    private String email;

    @Column("id_document_type")
    private Integer documentTypeId;
}
