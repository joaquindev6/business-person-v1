package com.jfarro.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private Integer personId;
    private DocumentType documentType;
    private String names;
    private String lastNames;
    private String fullName;
    private String documentNumber;
    private String phoneNumber;
    private String email;
}
