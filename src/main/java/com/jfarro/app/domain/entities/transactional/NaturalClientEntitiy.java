package com.jfarro.app.domain.entities.transactional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("natural_clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NaturalClientEntitiy {

    @Id
    @Column("id")
    private Integer naturalClientId;

    @Column("id_person")
    private Integer personId;

    @Column("father_last_name")
    private String fatherLastName;

    @Column("mother_last_name")
    private String motherLastName;

    @Column("names")
    private String names;
}
