package com.longhuei.pos_system_core.modules.productCodeGen.models;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product_size")
@Data
public class Size extends GenericEntity{
    
}