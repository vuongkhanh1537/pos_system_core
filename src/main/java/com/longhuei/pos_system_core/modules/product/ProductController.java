package com.longhuei.pos_system_core.modules.product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.product.dto.ProductCreateRequest;
import com.longhuei.pos_system_core.modules.product.dto.ProductUpdateRequest;
import com.longhuei.pos_system_core.utils.EntryService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(EntryService.PREFIX_PRODUCT)
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class ProductController {
    private final ProductService productService;

    @PostMapping("create")
    public BaseResponse<?> create(@RequestBody ProductCreateRequest request) {
        return this.productService.create(request);
    }

    @PutMapping("update/{id}")
    public BaseResponse<?> update(
        @PathVariable String id,
        @RequestBody ProductUpdateRequest request
    ) {
        return this.productService.update(id, request);
    }
 
    @DeleteMapping("delete/{id}")
    public BaseResponse<?> delete(
        @PathVariable String id
    ) {
        return this.productService.delete(id);
    }
}
