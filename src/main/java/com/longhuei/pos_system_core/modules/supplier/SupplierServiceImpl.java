package com.longhuei.pos_system_core.modules.supplier;

import org.springframework.stereotype.Service;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.exception.ApplicationException;
import com.longhuei.pos_system_core.exception.ErrorCode;
import com.longhuei.pos_system_core.modules.supplier.dto.SupplierCreateDTO;
import com.longhuei.pos_system_core.modules.supplier.dto.SupplierUpdateDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository splRepository;
    private final SupplierMapper splMapper;

    @Override
    public BaseResponse create(SupplierCreateDTO request) {

        try {
            Supplier spl = this.splMapper.toEntity(request);
            this.splRepository.save(spl);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return new BaseResponse<>();
    }

    @Override
    public BaseResponse delete(String id) {
        this.splRepository.findById(Integer.parseInt(id)).ifPresentOrElse((spl) -> {
            this.splRepository.delete(spl);
        }, () -> new ApplicationException(ErrorCode.SUPPLIER_NOT_EXISTED));
        return new BaseResponse<>();
    }

    @Override
    public BaseResponse update(String id, SupplierUpdateDTO request) {
        Supplier spl = this.splRepository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new ApplicationException(ErrorCode.SUPPLIER_NOT_EXISTED));
        this.splMapper.update(spl, request);
        return new BaseResponse<>();
    }

}