package com.longhuei.pos_system_core.modules.client;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.longhuei.pos_system_core.modules.client.dto.DeliveryAddressUpdateDTO;
import com.longhuei.pos_system_core.modules.client.dto.DeliveryAdressCreateDTO;

@Mapper(componentModel = "spring")
public interface DeliveryAddressMapper {

    DeliveryAddress toDeliveryAddress(DeliveryAdressCreateDTO dto);
    List<DeliveryAddress> toListOfDeliveryAddresses(List<DeliveryAdressCreateDTO> dtos);

    void updateToDeliveryAddress(@MappingTarget DeliveryAddress entity, DeliveryAddressUpdateDTO dto );
}