package com.longhuei.pos_system_core.modules.client;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.client.dto.ClientCreateDTO;
import com.longhuei.pos_system_core.modules.client.dto.ClientUpdateDTO;
import com.longhuei.pos_system_core.modules.client.dto.DeliveryAddressUpdateDTO;
import com.longhuei.pos_system_core.modules.client.dto.DeliveryAdressCreateDTO;
import com.longhuei.pos_system_core.utils.EntryService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
@RequestMapping(path = EntryService.PREFIX_CLIENT)
public class ClientController {
    private final ClientService clientService;

    @PostMapping(path = "/create")
    public BaseResponse create(@RequestBody @Valid ClientCreateDTO dto) {
        return this.clientService.create(dto);
    }

    @PostMapping(path = "/createAddress/{clientId}")
    public BaseResponse createAddressForClient(@PathVariable String clientId, DeliveryAdressCreateDTO request) {
        return this.clientService.createAddressForClient(clientId, request);
    }

    @PutMapping(path = "/update/{clientId}")
    public BaseResponse update(@PathVariable String clientId, @RequestBody @Valid ClientUpdateDTO dto) {
        return this.clientService.updateClient(clientId, dto);
    }

    @PutMapping(path = "/update/{clientId}/{addressId}")
    public BaseResponse update(@PathVariable String clientId, @PathVariable String addressId,
            @RequestBody @Valid DeliveryAddressUpdateDTO dto) {
        return this.clientService.updateDeliveryAddress(clientId, addressId, dto);
    }

    @DeleteMapping(path = "/delete/{clientId}")
    public BaseResponse delete(@PathVariable String clientId) {
        return this.clientService.deleteClient(clientId);
    }

    @DeleteMapping(path = "/deleteAddress/{addressId}")
    public BaseResponse deleteAddress(@PathVariable String addressId) {
        return this.clientService.deleteDeliveryAddress(addressId);
    }

}