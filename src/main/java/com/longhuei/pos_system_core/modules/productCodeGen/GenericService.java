package com.longhuei.pos_system_core.modules.productCodeGen;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.GenericDto;

public interface GenericService<D extends GenericDto> {
    BaseResponse<?> create(D dto);
    BaseResponse<?> update(D dto);
    BaseResponse<?> delete(String id);
    BaseResponse<?> findAll(); 
}
