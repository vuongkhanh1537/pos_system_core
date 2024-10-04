package com.longhuei.pos_system_core.modules.product.dto;

import lombok.Data;

@Data
public class ProductResponse {
    private String productCode;
    private String productName;
    private String modelType;
    private String colorType;
    private String remark;
}
