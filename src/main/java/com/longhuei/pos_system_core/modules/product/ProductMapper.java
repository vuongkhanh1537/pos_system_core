package com.longhuei.pos_system_core.modules.product;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.longhuei.pos_system_core.modules.product.dto.ProductCreateRequest;
import com.longhuei.pos_system_core.modules.product.dto.ProductResponse;
import com.longhuei.pos_system_core.modules.product.dto.ProductUpdateRequest;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductCreateRequest request);
    ProductResponse toResponse(Product entity);
    List<ProductResponse> toResponses(List<Product> list);
    void update(@MappingTarget Product entity, ProductUpdateRequest request);
}
