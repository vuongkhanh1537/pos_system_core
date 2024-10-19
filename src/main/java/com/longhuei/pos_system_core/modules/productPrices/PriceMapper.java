package com.longhuei.pos_system_core.modules.productPrices;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.longhuei.pos_system_core.modules.productPrices.dto.PriceListDTO;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    PriceList toEntity(PriceListDTO request);
    PriceListDTO toDTO(PriceList entity);
    void update(@MappingTarget PriceList entity, PriceListDTO request);
}
