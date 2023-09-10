package com.jfarro.app.domain.entities.search;

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
public class PersonSearchEntity {

    @Id
    @Column("id")
    private Integer personId;

    @Column("id_document_type")
    private Integer documentTypeId;

    @Column("document_number")
    private String documentNumber;

    @Column("phone_number")
    private String phoneNumber;

    @Column("email")
    private String email;

    @Column("code")
    private String code;

    @Column("long_name")
    private String longName;

    @Column("short_name")
    private String shortName;
}
