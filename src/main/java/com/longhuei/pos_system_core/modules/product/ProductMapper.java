package com.longhuei.pos_system_core.modules.product;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.longhuei.pos_system_core.modules.product.dto.ProductCreateRequest;
import com.longhuei.pos_system_core.modules.product.dto.ProductResponse;
import com.longhuei.pos_system_core.modules.product.dto.ProductUpdateRequest;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "modelCode", ignore = true)
    @Mapping(target = "colorCode", ignore = true)
    @Mapping(target = "coatingCode", ignore = true)
    @Mapping(target = "graphicCode", ignore = true)
    @Mapping(target = "labelCode", ignore = true)
    @Mapping(target = "sizeCode", ignore = true)
    Product toEntity(ProductCreateRequest request);

    void update(@MappingTarget Product entity, ProductUpdateRequest request);
}
