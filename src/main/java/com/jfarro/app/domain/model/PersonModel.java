package com.jfarro.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonModel {
    private Integer personId;
    private String documentNumber;
    private DocumentTypeModel documentTypeModel;
    private String phoneNumber;
    private String email;
}
