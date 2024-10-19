package com.longhuei.pos_system_core.modules.productCodeGen;

import java.util.List;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.exception.ApplicationException;
import com.longhuei.pos_system_core.exception.ErrorCode;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.GenericDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public abstract class GenericServiceImpl<E extends GenericEntity, D extends GenericDto> implements GenericService<D> {
    protected final GenericRepository<E> repository;
    protected final GenericMapper<E, D> mapper;
    protected E object;

    @Override
    public BaseResponse<?> create(D dto) {
        E entity = mapper.toEntity(dto);
        repository.save(entity);
        return new BaseResponse<>();
    }

    @Override
    public BaseResponse<?> update(D dto) {
        E entity = repository.findById(dto.getCode())
            .orElseThrow(() -> new ApplicationException(ErrorCode.NOT_FOUND));
        mapper.update(entity, dto);
        repository.save(entity);
        return new BaseResponse<>();
    }

    @Override
    public BaseResponse<?> delete(String id) {
        E entity = repository.findById(id)
            .orElseThrow(() -> new ApplicationException(ErrorCode.NOT_FOUND));
        entity.setDeleted(true);
        repository.save(entity);
        return new BaseResponse<>();
    }

    @Override
    public BaseResponse<?> findAll() {
        BaseResponse<List<D>> response = new BaseResponse<>();
        List<E> entities = repository.findAll();
        List<D> dtos = entities.stream().map(entity -> mapper.toDto(entity)).toList();
        response.setWsResponse(dtos);
        return response;
    }

    public E findById(String code) {
        return repository.findById(code)
            .orElseThrow(() -> new ApplicationException(object.getClass().getSimpleName() + " not found"));
    }
}
