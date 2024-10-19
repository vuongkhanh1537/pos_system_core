package com.longhuei.pos_system_core.modules.productCodeGen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericDto {
    protected String code;
    protected String nameEN;
    protected String nameCHT;
    protected String remark;

    
}
