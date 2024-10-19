package com.longhuei.pos_system_core.modules.productPrices;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.productPrices.dto.PriceListDTO;
import com.longhuei.pos_system_core.modules.productPrices.dto.PriceSearchRequest;
import com.longhuei.pos_system_core.utils.EntryService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(EntryService.PREFIX_PRICE)
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class PriceListController {
    private final PriceListService priceListService;

    @PostMapping("create")
    public BaseResponse<?> create(@RequestBody PriceListDTO request) {
        return this.priceListService.create(request);
    }

    @PutMapping("update")
    public BaseResponse<?> update(
        @RequestBody PriceListDTO request
    ) {
        return this.priceListService.update(request);
    }
 
    @DeleteMapping("delete/{id}")
    public BaseResponse<?> delete(
        @PathVariable String id
    ) {
        return this.priceListService.delete(id);
    }

    @PutMapping("active/{id}")
    public BaseResponse<?> active(
        @PathVariable String id
    ) {
        return this.priceListService.active(id);
    }

    @PostMapping("search")
    public BaseResponse<?> search(
        @RequestBody PriceSearchRequest request,
        Pageable pageable
    ) {
        return this.priceListService.search(request, pageable);
    }

    @GetMapping("getDetail/{id}")
    public BaseResponse<?> getDetail(
        @PathVariable String id
    ) {
        return this.priceListService.getDetail(id);
    }

}
