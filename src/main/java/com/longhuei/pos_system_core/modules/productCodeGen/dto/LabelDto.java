package com.longhuei.pos_system_core.modules.productCodeGen.dto;

public class LabelDto extends GenericDto {
    public LabelDto(String code, String nameEN, String nameCHT) {
        this.code = code;
        this.nameEN = nameEN;
        this.nameCHT = nameCHT;
    }
}
