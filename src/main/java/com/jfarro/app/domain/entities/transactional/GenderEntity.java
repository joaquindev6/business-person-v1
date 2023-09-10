package com.jfarro.app.domain.entities.transactional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("genders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenderEntity {

    @Id
    @Column("id")
    private Integer genderId;

    @Column("code")
    private String code;

    @Column("name")
    private String name;
}
