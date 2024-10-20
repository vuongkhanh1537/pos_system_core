package com.longhuei.pos_system_core.modules.productPrices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.longhuei.pos_system_core.modules.productPrices.models.PriceList;

public interface PriceListRepository extends JpaRepository<PriceList, String> {
    @Query("SELECT p FROM PriceList p WHERE p.id = :id AND p.isDeleted = false")
    Optional<PriceList> findById(String id);
}
