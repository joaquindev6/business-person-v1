package com.jfarro.app.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressEntity {

    @Id
    @Column("id")
    private Integer addressId;

    @Column("geolocation_code")
    private String geolocationCode;

    @Column("summary")
    private String summary;
}
