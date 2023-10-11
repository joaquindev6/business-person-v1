package com.jfarro.app.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("geographical_scopes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeographicalScopeEntity {

    @Id
    @Column("id")
    private Integer id;

    @Column("name")
    private String name;
}
