package com.jfarro.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentType {
    private Integer documentTypeId;
    private String code;
    private String name;
    private String nomenclature;
}
