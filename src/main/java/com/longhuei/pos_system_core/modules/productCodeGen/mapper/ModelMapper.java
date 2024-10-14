package com.longhuei.pos_system_core.modules.productCodeGen.mapper;

import org.mapstruct.Mapper;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericMapper;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.ModelDto;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Model;

@Mapper(componentModel = "spring")
public interface ModelMapper extends GenericMapper<Model, ModelDto> {
    
}
