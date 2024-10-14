package com.longhuei.pos_system_core.modules.productCodeGen.models;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "product_label")
@Data
@EqualsAndHashCode(callSuper=false)
public class Label extends GenericEntity {
    
}
