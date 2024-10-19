package com.longhuei.pos_system_core.modules.productPrices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.longhuei.pos_system_core.modules.productPrices.models.PriceList;

public interface PriceListRepository extends JpaRepository<PriceList, String> {
    
}
