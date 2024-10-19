package com.longhuei.pos_system_core.modules.productCodeGen.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericController;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.CoatingDto;
import com.longhuei.pos_system_core.modules.productCodeGen.services.CoatingService;
import com.longhuei.pos_system_core.utils.EntryService;

@RestController
@RequestMapping(EntryService.PREFIX_PRODUCT_COATING)
public class CoatingController extends GenericController<CoatingDto>{
    public CoatingController(CoatingService coatingService) {
        super(coatingService);
    }
}
