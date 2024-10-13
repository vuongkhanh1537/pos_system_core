package com.longhuei.pos_system_core.modules.client.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class ClientUpdateDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    private String fullNameEN;
    private String fullNameCHT;

    @NotNull
    @NotEmpty
    @NotBlank
    private String personInchargeEN;
    private String personInchargeCHT;

    private String bankAccount;
    private String bankName;
    private String tax;
    private String fax;
    private String line;
    // @Pattern(regexp = Const.EMAIL_PATTERN, message = "Email is invalid")
    @Email
    private String email;
    // @Pattern(regexp = Const.PHONENUMBER_PATTERN, message = "Phone number is
    // invalid")

    private String phoneNumber;
    private String website;

    private String address;
    private String province;
    private String area;
    private String country;

    private String remark;
}