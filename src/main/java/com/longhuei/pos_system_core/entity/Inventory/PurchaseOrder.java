package com.longhuei.pos_system_core.entity.Inventory;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.longhuei.pos_system_core.entity.enums.Currency;
import com.longhuei.pos_system_core.entity.enums.PaymentTerm;
import com.longhuei.pos_system_core.entity.enums.PurchaseOrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PurchaseOrder extends Order{
    @Enumerated(EnumType.STRING)
    private PaymentTerm paymentTerm;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime purchaseDate;

    
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate inStockDate;

    @Enumerated(EnumType.STRING)
    private PurchaseOrderStatus oderStatus;

    @Enumerated(EnumType.STRING)
    private Currency currency;
    
}

