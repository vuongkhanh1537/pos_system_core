package com.longhuei.pos_system_core.modules.client;

import java.util.List;

import com.longhuei.pos_system_core.models.BaseEntity;
import com.longhuei.pos_system_core.modules.saler.Saler;
import com.longhuei.pos_system_core.utils.enums.ClientStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Client extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String fullNameEN;
    private String fullNameCHT;

    @Enumerated(EnumType.STRING)
    private ClientStatus status = ClientStatus.ACTIVE_PARTNER;
    private String bankAccount;
    private String bankName;

    private String tax;
    private String fax;
    private String line;

    private String email;
    private String phoneNumber;
    private String website;

    private String personInchargeEN;
    private String personInchargeCHT;

    private String address;
    private String province;
    private String area;
    private String country;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeliveryAddress> deliveryAddresses;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "fk_to_saler", referencedColumnName = "id")
    private Saler saler;
}