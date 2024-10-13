package com.longhuei.pos_system_core.modules.client.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientCreateDTO extends ClientUpdateDTO {

    private List<DeliveryAdressCreateDTO> deliveryAddressesDTO;
}