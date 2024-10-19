package com.longhuei.pos_system_core.modules.supplier;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.supplier.dto.SupplierCreateDTO;
import com.longhuei.pos_system_core.modules.supplier.dto.SupplierUpdateDTO;

public interface SupplierService {
    BaseResponse create(SupplierCreateDTO request);

    BaseResponse update(String id, SupplierUpdateDTO request);

    BaseResponse delete(String id);
}