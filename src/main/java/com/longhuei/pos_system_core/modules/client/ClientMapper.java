package com.longhuei.pos_system_core.modules.client;


import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.longhuei.pos_system_core.modules.client.dto.ClientCreateDTO;
import com.longhuei.pos_system_core.modules.client.dto.ClientUpdateDTO;

@Mapper(componentModel = "spring", uses = {DeliveryAddressMapper.class})
public interface ClientMapper {

    Client toClient(ClientCreateDTO DTO);
    Client updateToClient(@MappingTarget Client entity, ClientUpdateDTO dto);

}