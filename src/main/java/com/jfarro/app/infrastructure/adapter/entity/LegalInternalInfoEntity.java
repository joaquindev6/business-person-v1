package com.jfarro.app.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "natural_internal_informations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LegalInternalInfoEntity {

    @Id
    @Column("id")
    private Integer legalInternalInfoId;

    @Column("id_economic_activity")
    private Integer economicActivityId;

    @Column("id_geographical_scope")
    private Integer geographicalScopeId;

    @Column("id_nationality")
    private Integer nationalityId;

    @Column("id_address")
    private Integer addressId;
}
