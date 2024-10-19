package com.longhuei.pos_system_core.modules.client.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeliveryAdressCreateDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    private String addressEN;
    private String addressCHT;

    @NotNull
    @NotEmpty
    @NotBlank
    private String consigneeEN;
    private String consigneeCHT;

    private String phoneNumber;

    private String taxID;

    private String remark;
}