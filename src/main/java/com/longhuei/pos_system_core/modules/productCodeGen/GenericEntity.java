package com.longhuei.pos_system_core.modules.productCodeGen;

import com.longhuei.pos_system_core.models.BaseEntity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class GenericEntity extends BaseEntity {
    @Id
    private String code;
    
    private String nameEN;
    private String nameCHT;
}
