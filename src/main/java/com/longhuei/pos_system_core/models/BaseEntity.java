package com.longhuei.pos_system_core.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseEntity extends AuditableEntity {
    
    protected String remark;
    
    protected boolean isDeleted = false;
}
