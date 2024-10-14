package com.longhuei.pos_system_core.modules.productCodeGen.mapper;

import org.mapstruct.Mapper;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericMapper;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.GraphicDto;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Graphic;

@Mapper(componentModel = "spring")
public interface GraphicMapper extends GenericMapper<Graphic, GraphicDto>{
    
}
