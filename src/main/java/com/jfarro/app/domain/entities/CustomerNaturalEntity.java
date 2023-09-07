package com.jfarro.app.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table("customer_natural")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerNaturalEntity {

    @Id
    @Column("id")
    private Integer customerNaturaId;

    @Column("id_person")
    private Integer personId;

    @Column("date_register")
    private Date dateRegister;

    @Column("date_modify")
    private Date dateModify;
}
