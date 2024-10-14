package com.longhuei.pos_system_core.modules.productCodeGen.services;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericServiceImpl;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.SizeDto;
import com.longhuei.pos_system_core.modules.productCodeGen.mapper.SizeMapper;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Size;
import com.longhuei.pos_system_core.modules.productCodeGen.repository.SizeRepository;

public class SizeService extends GenericServiceImpl<Size, SizeDto>{
    public SizeService(SizeRepository sizeRepository, SizeMapper sizeMapper) {
        super(sizeRepository, sizeMapper);
    }
}
