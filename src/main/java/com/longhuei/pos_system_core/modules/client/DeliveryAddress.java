package com.longhuei.pos_system_core.modules.client;

import com.longhuei.pos_system_core.models.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class DeliveryAddress extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String addressEN;
    private String addressCHT;

    private String consigneeEN;
    private String consigneeCHT;

    private String phoneNumber;

    private String taxID;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "fk_client", referencedColumnName = "id")
    private Client client;
}