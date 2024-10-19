package com.longhuei.pos_system_core.modules.saler.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.longhuei.pos_system_core.utils.enums.WorkingStatus;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class SalerCreateDTO {
    @NotEmpty
    @NotNull
    private String fullNameEN;
    private String fullNameCHT;

    private LocalDate joiningDate = LocalDate.now();
    private LocalDate leavingDate = null;
    
    @NotEmpty
    @NotNull
    private String primaryPhone;
    private String substantialPhone = "";

    @Email(message = "Email should be valid")
    private String email;
    private String address;

    private String remark = "";
    private WorkingStatus workingStatus = WorkingStatus.WORKING;
}