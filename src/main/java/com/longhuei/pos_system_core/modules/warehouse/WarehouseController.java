package com.longhuei.pos_system_core.modules.warehouse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.warehouse.dto.WarehouseCreateDTO;
import com.longhuei.pos_system_core.modules.warehouse.dto.WarehouseUpdateDTO;
import com.longhuei.pos_system_core.utils.EntryService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = EntryService.PREFIX_WAREHOUSE)
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class WarehouseController {
    private final WarehouseService warehouseService;

    @PostMapping("/create")
    public BaseResponse<?> create(@RequestBody(required = true) WarehouseCreateDTO dto) {
        return this.warehouseService.create(dto);
    }

    @PutMapping("/update/{id}")
    public BaseResponse<?> update(
            @PathVariable String id,
            @RequestBody(required = true) WarehouseUpdateDTO dto) {
        return this.warehouseService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse<?> delete(
        @PathVariable String id
    ) {
        return this.warehouseService.delete(id);
    }
}