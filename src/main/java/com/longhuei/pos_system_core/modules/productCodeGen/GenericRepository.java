package com.longhuei.pos_system_core.modules.productCodeGen;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T extends GenericEntity> extends JpaRepository<T, String> {
    
}
