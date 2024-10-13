package com.longhuei.pos_system_core.modules.client.dto;

import lombok.Data;

@Data
public class DeliveryAdressCreateDTO {
        private String addressEN;
        private String addressCHT;

        private String consigneeEN;
        private String consigneeCHT;

        // @Pattern(regexp = Const.PHONENUMBER_PATTERN, message = "Phone number is invalid")
        private String phoneNumber;

        private String taxID;

        private String remark;
}