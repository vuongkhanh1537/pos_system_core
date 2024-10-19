package com.longhuei.pos_system_core.modules.productPrices;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.productPrices.dto.PriceListDTO;
import com.longhuei.pos_system_core.modules.productPrices.dto.PriceSearchRequest;

public interface PriceListService {
    BaseResponse create(PriceListDTO request);
    BaseResponse update(PriceListDTO request);
    BaseResponse delete(String id);
    BaseResponse search(PriceSearchRequest request);
    BaseResponse active(String id);
    BaseResponse getDetail(String id);
}
