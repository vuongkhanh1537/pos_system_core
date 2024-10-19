package com.longhuei.pos_system_core.modules.supplier;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.longhuei.pos_system_core.modules.supplier.dto.SupplierCreateDTO;
import com.longhuei.pos_system_core.modules.supplier.dto.SupplierUpdateDTO;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    @Mapping(target = "supplierNameEN", source = "fullNameEn")
    @Mapping(target = "supplierNameCHT", source = "fullNameCHT")
    @Mapping(target = "personInChargeEN", source = "contactPersonEN")
    @Mapping(target = "personInChargeCHT", source = "contactPersonCHT")
    @Mapping(target = "phoneNumber", source = "primaryPhone")
    @Mapping(target = "tax", source = "taxId")
    SupplierCreateDTO toDTO(Supplier entity);

    @Mapping(source = "supplierNameEN", target = "fullNameEn")
    @Mapping(source = "supplierNameCHT", target = "fullNameCHT")
    @Mapping(source = "personInChargeEN", target = "contactPersonEN")
    @Mapping(source = "personInChargeCHT", target = "contactPersonCHT")
    @Mapping(source = "phoneNumber", target = "primaryPhone")
    @Mapping(source = "tax", target = "taxId")
    Supplier toEntity(SupplierCreateDTO dto);
    
    @Mapping(source = "supplierNameEN", target = "fullNameEn")
    @Mapping(source = "supplierNameCHT", target = "fullNameCHT")
    @Mapping(source = "personInChargeEN", target = "contactPersonEN")
    @Mapping(source = "personInChargeCHT", target = "contactPersonCHT")
    @Mapping(source = "phoneNumber", target = "primaryPhone")
    @Mapping(source = "tax", target = "taxId")
    void update(@MappingTarget Supplier entity, SupplierUpdateDTO dto);
}