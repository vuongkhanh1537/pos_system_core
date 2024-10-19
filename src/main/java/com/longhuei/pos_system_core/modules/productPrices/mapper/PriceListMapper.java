package com.longhuei.pos_system_core.modules.productPrices.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.longhuei.pos_system_core.modules.productPrices.dto.PriceListDTO;
import com.longhuei.pos_system_core.modules.productPrices.models.PriceList;

@Mapper(componentModel = "spring")
public interface PriceListMapper {
    @Mapping(target = "prices", ignore = true)
    PriceList toEntity(PriceListDTO request);
    PriceListDTO toDTO(PriceList entity);
    void update(@MappingTarget PriceList entity, PriceListDTO request);
}
