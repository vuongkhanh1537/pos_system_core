package com.longhuei.pos_system_core.modules.saler;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.saler.dto.SalerCreateDTO;
import com.longhuei.pos_system_core.modules.saler.dto.SalerUpdateDTO;
import com.longhuei.pos_system_core.utils.EntryService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = EntryService.PREFIX_SALER)
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class SalerController {
    private final SalerService service;

    @PostMapping("/create")
    public BaseResponse create(@RequestBody(required = true) @Valid SalerCreateDTO request) {
        return this.service.create(request);
    }

    @PutMapping("/update/{id}")
    public BaseResponse update(@PathVariable String id,
            @RequestBody(required = true) @Valid SalerUpdateDTO request) {
        return this.service.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse delete(@PathVariable String id) {
        return this.service.delete(id);
    }
}