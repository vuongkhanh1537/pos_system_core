package com.longhuei.pos_system_core.modules.saler;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalerRepository extends JpaRepository<Saler, Integer> {
}