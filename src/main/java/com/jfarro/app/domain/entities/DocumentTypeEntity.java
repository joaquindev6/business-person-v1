package com.jfarro.app.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "document_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentTypeEntity {

    @Id
    @Column("id")
    private Integer documentTypeId;

    @Column("code")
    private String code;

    @Column("name")
    private String name;

    @Column("nomenclature")
    private String nomenclature;
}
