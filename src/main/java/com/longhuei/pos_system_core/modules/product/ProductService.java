package com.longhuei.pos_system_core.modules.product;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.product.dto.ProductCreateRequest;
import com.longhuei.pos_system_core.modules.product.dto.ProductUpdateRequest;

public interface ProductService {
    BaseResponse create(ProductCreateRequest request);
    
    BaseResponse update(String id, ProductUpdateRequest request);
    
    BaseResponse delete(String id);
}
