package com.longhuei.pos_system_core.modules.productPrices.models;

import java.time.LocalDate;
import java.util.List;

import com.longhuei.pos_system_core.models.BaseEntity;
import com.longhuei.pos_system_core.utils.enums.CommonStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class PriceList extends BaseEntity {
    @Id
    private String id;

    private LocalDate effectiveDate;

    @Enumerated(EnumType.STRING)
    private CommonStatus status;

    @OneToMany(mappedBy = "priceList", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<PriceListItem> prices;
}
