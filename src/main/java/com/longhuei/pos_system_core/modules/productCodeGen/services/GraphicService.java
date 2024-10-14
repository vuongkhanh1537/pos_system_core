package com.longhuei.pos_system_core.modules.productCodeGen.services;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericServiceImpl;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.GraphicDto;
import com.longhuei.pos_system_core.modules.productCodeGen.mapper.GraphicMapper;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Graphic;
import com.longhuei.pos_system_core.modules.productCodeGen.repository.GraphicRepository;

public class GraphicService extends GenericServiceImpl<Graphic, GraphicDto>{
    public GraphicService(GraphicRepository graphicRepository, GraphicMapper graphicMapper) {
        super(graphicRepository, graphicMapper);
    }
}
