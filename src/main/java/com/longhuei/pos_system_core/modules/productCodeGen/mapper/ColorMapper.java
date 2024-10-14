package com.longhuei.pos_system_core.modules.productCodeGen.mapper;

import org.mapstruct.Mapper;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericMapper;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.ColorDto;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Color;

@Mapper(componentModel = "spring")
public interface ColorMapper extends GenericMapper<Color, ColorDto>{
    
}
