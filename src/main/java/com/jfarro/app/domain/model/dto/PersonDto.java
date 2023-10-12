package com.jfarro.app.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto implements Serializable {
    private Long id;
    private String documentNumber;
    private DocumentTypeDto documentType;
    private String phoneNumber;
    private String email;
}
