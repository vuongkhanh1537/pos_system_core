package com.longhuei.pos_system_core.modules.supplier.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SupplierCreateDTO {
    @NotEmpty
    @NotNull
    private String supplierNameEN;
    private String supplierNameCHT;

    @NotEmpty
    @NotNull
    private String personInChargeEN;
    private String personInChargeCHT;

    private String address;
    private String phoneNumber;

    @Email(message = "Email should be valid")
    @NotEmpty
    private String email;

    private String fax;

    private String bankName;
    private String bankAccount;
    private String tax;

    private String remark;
}