package com.longhuei.pos_system_core.modules.productPrices.dto;

import lombok.Data;

@Data
public class PriceListItemDTO {
    private Long id;
    private String productId;
    private Double buyPrice;
    private Double sellPrice;
    private Double remark;
}
