package com.longhuei.pos_system_core.modules.productCodeGen.mapper;

import org.mapstruct.Mapper;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericMapper;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.CoatingDto;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Coating;

@Mapper(componentModel = "spring")
public interface CoatingMapper extends GenericMapper<Coating, CoatingDto> {
    
}
