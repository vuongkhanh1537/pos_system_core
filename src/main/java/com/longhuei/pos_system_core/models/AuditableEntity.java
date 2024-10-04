package com.longhuei.pos_system_core.models;

import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.ToString;

@MappedSuperclass
@Data
@ToString
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity {
    @CreatedBy
    @Column(name = "CREATED_BY", length = 50, updatable = false)
    protected String createdBy;

    @CreatedDate
    @Column(name = "CREATED_AT", updatable = false)
    protected Instant createdAt = Instant.now();

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY", length = 50)
    protected String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_AT")
    protected Instant lastModifiedAt = Instant.now();
}
