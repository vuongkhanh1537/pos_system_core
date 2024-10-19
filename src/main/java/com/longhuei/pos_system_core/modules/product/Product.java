package com.longhuei.pos_system_core.modules.product;

import java.time.LocalDate;

import com.longhuei.pos_system_core.models.BaseEntity;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Coating;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Color;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Graphic;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Label;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Model;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Size;
import com.longhuei.pos_system_core.modules.productPrices.models.PriceListItem;
import com.longhuei.pos_system_core.utils.enums.ProductStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {
    @Id
    private String productId;
    private String productName;
    private String modelType;
    private String colorType;
    private String packageQuantity;
    private String barCode;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    
    private LocalDate stopDate;
    private LocalDate resumeDate;

    private Long currentPriceListItemId;

    private String specialCode;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "label_code")
    private Label labelCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_code")
    private Model modelCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coating_code")
    private Coating coatingCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_code")
    private Color colorCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_code")
    private Size sizeCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "graphic_code")
    private Graphic graphicCode;
}
