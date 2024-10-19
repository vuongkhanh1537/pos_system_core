package com.longhuei.pos_system_core.modules.productPrices.dto;

import lombok.Data;

@Data
public class PriceListItemDTO {
    private String product;

    private Double buyPrice;
    private Double sellPrice;
}
