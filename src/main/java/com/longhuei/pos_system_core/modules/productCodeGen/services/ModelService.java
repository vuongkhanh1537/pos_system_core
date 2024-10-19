package com.longhuei.pos_system_core.modules.productCodeGen.services;

import org.springframework.stereotype.Service;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericServiceImpl;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.ModelDto;
import com.longhuei.pos_system_core.modules.productCodeGen.mapper.ModelMapper;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Model;
import com.longhuei.pos_system_core.modules.productCodeGen.repository.ModelRepository;


@Service
public class ModelService extends GenericServiceImpl<Model, ModelDto> {
    public ModelService(ModelRepository repository, ModelMapper mapper) {
        super(repository, mapper);
    }
}
