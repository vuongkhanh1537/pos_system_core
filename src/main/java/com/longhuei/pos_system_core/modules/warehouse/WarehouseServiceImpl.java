package com.longhuei.pos_system_core.modules.warehouse;

import org.springframework.stereotype.Service;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.exception.ApplicationException;
import com.longhuei.pos_system_core.exception.ErrorCode;
import com.longhuei.pos_system_core.modules.warehouse.dto.WarehouseCreateDTO;
import com.longhuei.pos_system_core.modules.warehouse.dto.WarehouseUpdateDTO;
import com.longhuei.pos_system_core.utils.Const;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository whRepository;
    private final WarehouseMapper whMapper;

    @Override
    public BaseResponse create(WarehouseCreateDTO request) {
        Warehouse wh = this.whMapper.toEntity(request);
        this.whRepository.save(wh);
        return new BaseResponse<Warehouse>();
    }

    @Override
    public BaseResponse delete(String id) {
        this.whRepository.findById(Integer.parseInt(id)).ifPresentOrElse(warehouse -> {
            warehouse.setDeleted(Const.ACTIVE);
            this.whRepository.save(warehouse);
        }, () -> new ApplicationException(ErrorCode.WAREHOUSE_NOT_EXISTED));

        return new BaseResponse<>();
    }

    @Override
    public BaseResponse update(String id, WarehouseUpdateDTO request) {
        Warehouse whEntity = this.whRepository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new ApplicationException(ErrorCode.WAREHOUSE_NOT_EXISTED));
        this.whMapper.update(whEntity, request);
        this.whRepository.save(whEntity);
        return new BaseResponse<Warehouse>();
    }

}