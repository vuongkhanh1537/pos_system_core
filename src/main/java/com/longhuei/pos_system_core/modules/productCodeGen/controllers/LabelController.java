package com.longhuei.pos_system_core.modules.productCodeGen.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericController;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.LabelDto;
import com.longhuei.pos_system_core.modules.productCodeGen.services.LabelService;

import com.longhuei.pos_system_core.utils.EntryService;


@RestController
@RequestMapping(EntryService.PREFIX_PRODUCT_LABEL)
public class LabelController extends GenericController<LabelDto> {
    public LabelController(LabelService labelService) {
        super(labelService);
    }
}
