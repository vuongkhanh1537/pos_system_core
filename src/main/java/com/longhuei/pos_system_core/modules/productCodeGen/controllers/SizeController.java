package com.longhuei.pos_system_core.modules.productCodeGen.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericController;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.SizeDto;
import com.longhuei.pos_system_core.modules.productCodeGen.services.SizeService;
import com.longhuei.pos_system_core.utils.EntryService;

@RestController
@RequestMapping(EntryService.PREFIX_PRODUCT_SIZE)
public class SizeController extends GenericController<SizeDto>{
    public SizeController(SizeService sizeService) {
        super(sizeService);
    }
}
