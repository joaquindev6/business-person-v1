package com.jfarro.app.domain.entities.transactional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table(name = "natural_internal_informations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NaturalInternalInfoEntity {

    @Id
    @Column("id")
    private Integer naturalInternalInfoId;

    @Column("birth_date")
    private Date birthDate;

    @Column("id_gender")
    private Integer genderId;

    @Column("id_nationality")
    private Integer nationalityId;

    @Column("id_address")
    private Integer addressId;
}
