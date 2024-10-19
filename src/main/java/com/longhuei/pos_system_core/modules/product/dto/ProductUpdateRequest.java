package com.longhuei.pos_system_core.modules.product.dto;

import java.time.LocalDate;

import com.longhuei.pos_system_core.modules.productCodeGen.models.Coating;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Color;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Graphic;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Label;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Model;
import com.longhuei.pos_system_core.modules.productCodeGen.models.Size;
import com.longhuei.pos_system_core.utils.enums.ProductStatus;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private String productName;
    private String modelType;
    private String colorType;
    private String packageQuantity;
    private String barCode;
    private ProductStatus status;    

    private LocalDate stopDate;
    
    private String remark;
}
