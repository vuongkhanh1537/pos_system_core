package com.longhuei.pos_system_core.modules.productCodeGen;

import org.mapstruct.MappingTarget;

import com.longhuei.pos_system_core.modules.productCodeGen.dto.GenericDto;

public interface GenericMapper<E extends GenericEntity, D extends GenericDto> {
    D toDto(E entity);
    E toEntity(D dto);
    void update(@MappingTarget E entity, D dto);
}
