package com.longhuei.pos_system_core.modules.productCodeGen.services;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericServiceImpl;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.ColorDto;
import com.longhuei.pos_system_core.modules.productCodeGen.mapper.ColorMapper;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Color;
import com.longhuei.pos_system_core.modules.productCodeGen.repository.ColorRepository;

public class ColorService extends GenericServiceImpl<Color, ColorDto>{
    public ColorService(ColorRepository colorRepository, ColorMapper colorMapper) {
        super(colorRepository, colorMapper);
    }
}
