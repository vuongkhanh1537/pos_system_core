package com.longhuei.pos_system_core.modules.saler;

import org.springframework.stereotype.Service;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.exception.ApplicationException;
import com.longhuei.pos_system_core.exception.ErrorCode;
import com.longhuei.pos_system_core.modules.saler.dto.SalerCreateDTO;
import com.longhuei.pos_system_core.modules.saler.dto.SalerUpdateDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SalerServiceImpl implements SalerService {
    private final SalerRepository repository;
    private final SalerMapper mapper;

    @Override
    public BaseResponse create(SalerCreateDTO request) {
        Saler newSaler = this.mapper.toEntity(request);
        this.repository.save(newSaler);
        return new BaseResponse<>();
    }

    @Override
    public BaseResponse delete(String id) {
        this.repository.findById(Integer.parseInt(id)).ifPresentOrElse((saler) -> {
            saler.setDeleted(true);
            this.repository.save(saler);
        }, () -> new ApplicationException(ErrorCode.SALER_NOT_EXISTED));
        return new BaseResponse<>();

    }

    @Override
    public BaseResponse update(String id, SalerUpdateDTO request) {
        Saler saler = this.repository.findById(Integer.parseInt(id)).orElseThrow(() -> new ApplicationException(ErrorCode.SALER_NOT_EXISTED));
        log.info(saler.toString());
        this.mapper.update(saler, request);
        this.repository.save(saler);
        log.info(saler.toString());
        return new BaseResponse<>();
    }

}