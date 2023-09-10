package com.jfarro.app.domain.entities.transactional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("legal_clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LegalClientEntity {

    @Id
    @Column("id")
    private Integer legalClientId;

    @Column("id_person")
    private Integer personId;

    @Column("business_name")
    private String businessName;
}
