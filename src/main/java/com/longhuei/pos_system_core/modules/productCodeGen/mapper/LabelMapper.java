package com.longhuei.pos_system_core.modules.productCodeGen.mapper;

import org.mapstruct.Mapper;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericMapper;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.LabelDto;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Label;

@Mapper(componentModel = "spring")
public interface LabelMapper extends GenericMapper<Label, LabelDto> {
    
}
