package com.longhuei.pos_system_core.modules.productPrices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import com.longhuei.pos_system_core.modules.productPrices.models.PriceListSequence;

import jakarta.persistence.LockModeType;

public interface PriceListSequenceRepository extends JpaRepository<PriceListSequence, Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT p FROM PriceListSequence p")
    PriceListSequence getSequenceForUpdate();
}
