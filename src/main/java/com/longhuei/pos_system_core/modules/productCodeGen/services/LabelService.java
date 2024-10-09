package com.longhuei.pos_system_core.modules.productCodeGen.services;

import org.springframework.stereotype.Service;

import com.longhuei.pos_system_core.modules.productCodeGen.GenericServiceImpl;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.LabelDto;
import com.longhuei.pos_system_core.modules.productCodeGen.mapper.LabelMapper;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Label;
import com.longhuei.pos_system_core.modules.productCodeGen.repository.LabelRepository;

@Service
public class LabelService extends GenericServiceImpl<Label, LabelDto>{
    public LabelService(LabelRepository repository, LabelMapper mapper) {
        super(repository, mapper);
    }
}
