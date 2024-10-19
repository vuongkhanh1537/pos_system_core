package com.longhuei.pos_system_core.modules.productCodeGen.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericController;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.ModelDto;
import com.longhuei.pos_system_core.modules.productCodeGen.services.ModelService;
import com.longhuei.pos_system_core.utils.EntryService;

@RestController
@RequestMapping(EntryService.PREFIX_PRODUCT_MODEL)
public class ModelController extends GenericController<ModelDto> {
    public ModelController(ModelService modelService) {
        super(modelService);
    }
}
