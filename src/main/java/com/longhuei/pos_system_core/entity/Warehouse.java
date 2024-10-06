package com.longhuei.pos_system_core.entity;

import com.longhuei.pos_system_core.models.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Warehouse extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String nameEN;
    private String nameCHT;
    private String personInChargeEN;
    private String personInChargeCHT;
    private String address;
}