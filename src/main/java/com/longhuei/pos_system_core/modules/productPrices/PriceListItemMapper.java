package com.longhuei.pos_system_core.modules.productPrices;

import org.mapstruct.MappingTarget;

import com.longhuei.pos_system_core.modules.productPrices.dto.PriceListItemDTO;

public interface PriceListItemMapper {
    PriceListItem toEntity(PriceListItemDTO request);
    PriceListItemDTO toDTO(PriceListItem entity);
    void update(@MappingTarget PriceListItem entity, PriceListItemDTO request);
}
