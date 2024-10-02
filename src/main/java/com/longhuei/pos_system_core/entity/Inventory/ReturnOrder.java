package com.longhuei.pos_system_core.entity.Inventory;

import java.time.LocalDateTime;
import java.util.Currency;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.longhuei.pos_system_core.entity.enums.GoodsStatus;
import com.longhuei.pos_system_core.entity.enums.ReturnOrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ReturnOrder extends Order{
     @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime returnDate;

    @Enumerated(EnumType.STRING)
    private GoodsStatus goodsStatus;

    @Enumerated(EnumType.STRING)    
    private ReturnOrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private Currency currency;
}