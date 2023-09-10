package com.jfarro.app.domain.entities.transactional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("economic_activities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EconomicActivityEntity {

    @Id
    @Column("id")
    private Integer economicActivityId;

    @Column("sector")
    private String sector;
}
