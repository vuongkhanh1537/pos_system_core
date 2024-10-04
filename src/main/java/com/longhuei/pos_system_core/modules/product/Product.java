package com.longhuei.pos_system_core.modules.product;

import com.longhuei.pos_system_core.models.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {
    @Id
    private String productCode;
    private String productName;
    private String modelType;
    private String colorType;
}
