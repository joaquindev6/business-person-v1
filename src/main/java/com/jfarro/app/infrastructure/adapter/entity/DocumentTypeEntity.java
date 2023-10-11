package com.jfarro.app.infrastructure.adapter.entity;

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
    private Long id;

    @Column("code")
    private String code;

    @Column("long_name")
    private String longName;

    @Column("short_name")
    private String shortName;
}
