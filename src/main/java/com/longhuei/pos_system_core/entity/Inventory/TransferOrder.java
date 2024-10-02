package com.longhuei.pos_system_core.entity.Inventory;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.longhuei.pos_system_core.entity.enums.TransferOrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class TransferOrder extends Order {
    @Enumerated(EnumType.STRING)
    private TransferOrderStatus orderStatus;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime transferDate;
}