package com.longhuei.pos_system_core.modules.productCodeGen.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericController;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.ColorDto;
import com.longhuei.pos_system_core.modules.productCodeGen.services.ColorService;
import com.longhuei.pos_system_core.utils.EntryService;

@RestController
@RequestMapping(EntryService.PREFIX_PRODUCT_COLOR)
public class ColorController extends GenericController<ColorDto>{
    public ColorController(ColorService colorService) {
        super(colorService);
    }
}
