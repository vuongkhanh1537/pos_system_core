package com.longhuei.pos_system_core.modules.saler;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.saler.dto.SalerCreateDTO;
import com.longhuei.pos_system_core.modules.saler.dto.SalerUpdateDTO;

public interface SalerService {
    BaseResponse create(SalerCreateDTO request);

    BaseResponse update(String id, SalerUpdateDTO request);

    BaseResponse delete(String id);
}