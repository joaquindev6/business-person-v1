package com.jfarro.app.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentTypeDto {
    private Long id;
    private String code;
    private String longName;
    private String shortName;
}
