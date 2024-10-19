package com.longhuei.pos_system_core.modules.productPrices.dto;

import java.time.LocalDate;
import java.util.List;

import com.longhuei.pos_system_core.modules.productPrices.PriceListItem;
import com.longhuei.pos_system_core.utils.enums.CommonStatus;

import lombok.Data;

@Data
public class PriceListDTO {
    private String id;
    private LocalDate effectiveDate;
    private CommonStatus status;
    private List<PriceListItem> prices;
}
