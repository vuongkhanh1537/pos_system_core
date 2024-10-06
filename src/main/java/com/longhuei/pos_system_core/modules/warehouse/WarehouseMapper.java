package com.longhuei.pos_system_core.modules.warehouse;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.longhuei.pos_system_core.entity.Warehouse;
import com.longhuei.pos_system_core.modules.warehouse.dto.WarehouseCreateDTO;
import com.longhuei.pos_system_core.modules.warehouse.dto.WarehouseUpdateDTO;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {
    Warehouse toEntity(WarehouseCreateDTO dto);
    void update(@MappingTarget Warehouse whEntity, WarehouseUpdateDTO whDTO);
}