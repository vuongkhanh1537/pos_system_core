package com.longhuei.pos_system_core.modules.productCodeGen.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericController;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.GraphicDto;
import com.longhuei.pos_system_core.modules.productCodeGen.services.GraphicService;
import com.longhuei.pos_system_core.utils.EntryService;

@RestController
@RequestMapping(EntryService.PREFIX_PRODUCT_GRAPHIC)
public class GraphicController extends GenericController<GraphicDto>{
    public GraphicController(GraphicService graphicService) {
        super(graphicService);
    }
}
