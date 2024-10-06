package com.longhuei.pos_system_core.modules.warehouse.dto;

import lombok.Data;

@Data
public class WarehouseCreateDTO {
    private String nameEN;
    private String nameCHT;
    private String personInChargeEN;
    private String personInChargeCHT;
    private String address;
    private String remark;
}