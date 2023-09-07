package com.jfarro.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerNatural {
    private Integer customerNaturaId;
    private Person person;
    private Date dateRegister;
    private Date dateModify;
}
