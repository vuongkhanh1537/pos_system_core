package com.longhuei.pos_system_core.modules.productPrices.models;

import java.time.LocalDate;
import java.util.List;

import com.longhuei.pos_system_core.models.BaseEntity;
import com.longhuei.pos_system_core.utils.enums.CommonStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class PriceList extends BaseEntity {
    @Id
    private String id;

    private LocalDate effectiveDate;

    private CommonStatus status;

    @OneToMany(mappedBy = "priceList")
    private List<PriceListItem> prices;
}
