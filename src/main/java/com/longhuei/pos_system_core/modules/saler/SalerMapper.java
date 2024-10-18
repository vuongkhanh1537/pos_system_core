package com.longhuei.pos_system_core.modules.saler;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.longhuei.pos_system_core.modules.saler.dto.SalerCreateDTO;
import com.longhuei.pos_system_core.modules.saler.dto.SalerGetDTO;
import com.longhuei.pos_system_core.modules.saler.dto.SalerSelectDTO;
import com.longhuei.pos_system_core.modules.saler.dto.SalerUpdateDTO;

@Mapper(componentModel = "spring")
public interface SalerMapper {

    Saler toEntity(SalerCreateDTO dto);

    List<SalerGetDTO> toListSalerGetDTOs(List<Saler> listOfSalers);

    void update(@MappingTarget Saler saler, SalerUpdateDTO request);
}