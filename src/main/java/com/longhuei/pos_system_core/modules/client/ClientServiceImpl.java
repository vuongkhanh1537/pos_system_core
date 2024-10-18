package com.longhuei.pos_system_core.modules.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.exception.ApplicationException;
import com.longhuei.pos_system_core.exception.ErrorCode;
import com.longhuei.pos_system_core.modules.client.dto.ClientCreateDTO;
import com.longhuei.pos_system_core.modules.client.dto.ClientUpdateDTO;
import com.longhuei.pos_system_core.modules.client.dto.DeliveryAddressUpdateDTO;
import com.longhuei.pos_system_core.modules.client.dto.DeliveryAdressCreateDTO;
import com.longhuei.pos_system_core.modules.saler.Saler;
import com.longhuei.pos_system_core.modules.saler.SalerRepository;
import com.longhuei.pos_system_core.utils.enums.ClientStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final DeliveryAddressRepository deliveryAddressRepository;
    private final ClientMapper clientMapper;
    private final DeliveryAddressMapper deliveryAddressMapper;
    private final SalerRepository salerRepository;

    @Override
    public BaseResponse<?> create(ClientCreateDTO request) {
        Client client = clientMapper.toClient(request);
        List<DeliveryAddress> deliveryAddresses = new ArrayList<>();

        request.getDeliveryAddressesDTO().stream().forEach((deliveryAddressesDTO) -> {
            DeliveryAddress deliveryAddress = this.deliveryAddressMapper.toDeliveryAddress(deliveryAddressesDTO);
            deliveryAddress.setClient(client);
            deliveryAddresses.add(deliveryAddress);
        });

        Saler saler = this.salerRepository.findById(request.getSaler().getId()).orElseThrow(() -> new ApplicationException(ErrorCode.SALER_NOT_EXISTED));

        client.setDeliveryAddresses(deliveryAddresses);
        client.setSaler(saler);
        this.clientRepository.save(client);
        this.deliveryAddressRepository.saveAll(deliveryAddresses);
        this.salerRepository.save(saler);

        return new BaseResponse<>();
    }

    @Override
    public BaseResponse<?> createAddressForClient(String clientId, DeliveryAdressCreateDTO request) {
        Client client = this.findClientHelper(clientId);
        DeliveryAddress address = this.deliveryAddressMapper.toDeliveryAddress(request);

        address.setClient(client);

        this.deliveryAddressRepository.save(address);

        return new BaseResponse<>();
    }

    @Override
    public BaseResponse<?> deleteClient(String clientId) {
        this.clientRepository.findById(Integer.parseInt(clientId)).ifPresentOrElse((client) -> {
            client.setStatus(ClientStatus.INACTIVE_PARTNER);
            client.setDeleted(true);
            this.clientRepository.save(client);
        }, () -> new ApplicationException(ErrorCode.CLIENT_NOT_EXISTED));
        return new BaseResponse<>();
    }

    @Override
    public BaseResponse<?> deleteDeliveryAddress(String addressId) {
        this.deliveryAddressRepository.findById(Integer.parseInt(addressId)).ifPresentOrElse((address) -> {
            address.setDeleted(true);
            this.deliveryAddressRepository.save(address);
        }, () -> new ApplicationException(ErrorCode.DELIVERY_ADDR_NOT_EXISTED));
        return null;
    }

    @Override
    public BaseResponse<?> updateClient(String clientId, ClientUpdateDTO request) {
        Client client = this.findClientHelper(clientId);
        this.clientMapper.updateToClient(client, request);
        Saler saler = this.salerRepository.findById(request.getSaler().getId()).orElseThrow(() -> new ApplicationException(ErrorCode.SALER_NOT_EXISTED));
        client.setSaler(saler);
        this.clientRepository.save(client);
        return null;
    }

    @Override
    public BaseResponse<?> updateDeliveryAddress(String clientId, String addressId, DeliveryAddressUpdateDTO request) {
        Client client = this.findClientHelper(clientId);

        DeliveryAddress deliveryAddress = client.getDeliveryAddresses()
                .stream()
                .filter(deliveryAddressParam -> deliveryAddressParam.getId().toString().equals(addressId))
                .findFirst().orElseThrow(() -> new ApplicationException(ErrorCode.DELIVERY_ADDR_NOT_EXISTED));

        this.deliveryAddressMapper.updateToDeliveryAddress(deliveryAddress, request);
        this.deliveryAddressRepository.save(deliveryAddress);
        return null;
    }

    private Client findClientHelper(String clientId) {
        return this.clientRepository.findById(Integer.parseInt(clientId))
                .orElseThrow(() -> new ApplicationException(ErrorCode.CLIENT_NOT_EXISTED));
    }


}
