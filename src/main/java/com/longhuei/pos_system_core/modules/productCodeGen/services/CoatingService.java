package com.longhuei.pos_system_core.modules.productCodeGen.services;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericServiceImpl;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.CoatingDto;
import com.longhuei.pos_system_core.modules.productCodeGen.mapper.CoatingMapper;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Coating;
import com.longhuei.pos_system_core.modules.productCodeGen.repository.CoatingRepository;

public class CoatingService extends GenericServiceImpl<Coating, CoatingDto>{
    public CoatingService(CoatingRepository coatingRepository, CoatingMapper coatingMapper) {
        super(coatingRepository, coatingMapper);
    }
}
