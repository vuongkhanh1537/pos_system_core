package com.longhuei.pos_system_core.modules.productCodeGen.mapper;

import org.mapstruct.Mapper;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericMapper;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.SizeDto;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Size;

@Mapper(componentModel = "spring")
public interface SizeMapper extends GenericMapper<Size, SizeDto>{
    
}
