package com.longhuei.pos_system_core.entity.Inventory;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.longhuei.pos_system_core.entity.enums.CheckOrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CheckOrder extends Order {
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate checkDate;

    @Enumerated(EnumType.STRING)
    private CheckOrderStatus orderStatus;

}