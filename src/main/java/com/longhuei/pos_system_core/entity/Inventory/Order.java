package com.longhuei.pos_system_core.entity.Inventory;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String remark;

    @ColumnDefault(value = "0")
    private boolean is_deleted;
}