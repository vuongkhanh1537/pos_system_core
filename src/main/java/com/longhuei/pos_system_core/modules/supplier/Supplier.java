package com.longhuei.pos_system_core.modules.supplier;

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
public class Supplier extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;

    private String fax;
    private String taxId;
    private String bankAccount;
    private String bankName;
    private String fullNameEn;
    private String fullNameCHT;
    private String contactPersonEN;
    private String contactPersonCHT;
    private String address;

    private String primaryPhone;
    private String email;
}