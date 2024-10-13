package com.longhuei.pos_system_core.modules.client;


import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.client.dto.ClientCreateDTO;
import com.longhuei.pos_system_core.modules.client.dto.ClientUpdateDTO;
import com.longhuei.pos_system_core.modules.client.dto.DeliveryAddressUpdateDTO;
import com.longhuei.pos_system_core.modules.client.dto.DeliveryAdressCreateDTO;

public interface ClientService {
    BaseResponse<?> create(ClientCreateDTO request);

    BaseResponse<?> createAddressForClient(String clientId, DeliveryAdressCreateDTO request);

    BaseResponse<?> updateClient(String clientId, ClientUpdateDTO request);

    BaseResponse<?> updateDeliveryAddress(String clientId, String addressId, DeliveryAddressUpdateDTO request);

    BaseResponse<?> deleteClient(String clientId);

    BaseResponse<?> deleteDeliveryAddress(String addressId);

}