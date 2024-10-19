package com.longhuei.pos_system_core.modules.supplier;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.supplier.dto.SupplierCreateDTO;
import com.longhuei.pos_system_core.modules.supplier.dto.SupplierUpdateDTO;
import com.longhuei.pos_system_core.utils.EntryService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = EntryService.PREFIX_SUPPLIER)
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class SupplierController {
    private final SupplierService service;

    @PostMapping("/create")
    public BaseResponse<?> create(@RequestBody(required = true) @Valid SupplierCreateDTO dto) {
        return this.service.create(dto);
    }

    @PutMapping("/update/{id}")
    public BaseResponse<?> update(@PathVariable String id, @RequestBody(required = true) @Valid SupplierUpdateDTO dto) {
        return this.service.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse<?> delete(@PathVariable String id) {
        return this.service.delete(id);
    }
}