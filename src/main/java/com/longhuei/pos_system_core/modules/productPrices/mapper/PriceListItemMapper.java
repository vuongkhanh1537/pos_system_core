package com.longhuei.pos_system_core.modules.productPrices.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.longhuei.pos_system_core.modules.productPrices.dto.PriceListItemDTO;
import com.longhuei.pos_system_core.modules.productPrices.models.PriceListItem;

@Mapper(componentModel = "spring")
public interface PriceListItemMapper {
    PriceListItem toEntity(PriceListItemDTO request);

    @Mapping(target = "productId", source="product.productId")
    PriceListItemDTO toDTO(PriceListItem entity);

    void update(@MappingTarget PriceListItem entity, PriceListItemDTO request);
}
