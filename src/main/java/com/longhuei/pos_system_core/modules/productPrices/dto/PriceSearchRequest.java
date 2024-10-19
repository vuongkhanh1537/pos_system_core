package com.longhuei.pos_system_core.modules.productPrices.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PriceSearchRequest {
    private String keyword;
    private LocalDate startDate;
    private LocalDate endDate;
}
