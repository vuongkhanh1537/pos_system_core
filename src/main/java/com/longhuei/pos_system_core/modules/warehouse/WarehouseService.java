package com.longhuei.pos_system_core.modules.warehouse;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.product.dto.ProductCreateRequest;
import com.longhuei.pos_system_core.modules.product.dto.ProductUpdateRequest;
import com.longhuei.pos_system_core.modules.warehouse.dto.WarehouseCreateDTO;
import com.longhuei.pos_system_core.modules.warehouse.dto.WarehouseUpdateDTO;

public interface WarehouseService {
    BaseResponse create(WarehouseCreateDTO request);
    
    BaseResponse update(String id, WarehouseUpdateDTO request);
    
    BaseResponse delete(String id);
}