package com.longhuei.pos_system_core.modules.saler;

import com.longhuei.pos_system_core.models.BaseEntity;
import com.longhuei.pos_system_core.utils.enums.WorkingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Saler extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String fullNameEN;
    private String fullNameCHT;

    private String address;

    private String email;
    private String primaryPhone;
    private String substantialPhone = null;

    private LocalDateTime joiningDate;
    private LocalDateTime leavingDate = null;


    @Enumerated(EnumType.STRING)
    private WorkingStatus workingStatus;
}