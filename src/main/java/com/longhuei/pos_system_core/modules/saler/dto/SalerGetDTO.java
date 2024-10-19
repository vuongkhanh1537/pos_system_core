package com.longhuei.pos_system_core.modules.saler.dto;

import com.longhuei.pos_system_core.utils.enums.WorkingStatus;

import lombok.Data;

@Data
public class SalerGetDTO {
    private Integer id;
    private String salePersonNameEN;
    private String salePersonNameCHT;
    private String email;
    private String phoneNumber;
    private WorkingStatus status;
    private String remark;
}