package com.longhuei.pos_system_core.modules.productCodeGen;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.GenericDto;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public abstract class GenericController<D extends GenericDto> {
    protected final GenericService<D> service;

    @PostMapping("create")
    public BaseResponse<?> create(@RequestBody D request) {
        return service.create(request);
    }

    @PutMapping("update")
    public BaseResponse<?> update(@RequestBody D request) {
        return service.update(request);
    }

    @DeleteMapping("delete/{id}")
    public BaseResponse<?> delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("findAll")
    public BaseResponse<?> findAll() {
        return service.findAll();
    }
}
