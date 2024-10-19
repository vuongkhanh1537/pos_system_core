package com.longhuei.pos_system_core.modules.product.dto;

import com.longhuei.pos_system_core.utils.enums.ProductStatus;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductCreateRequest {
    @NotBlank
    private String productId;
    
    @NotBlank
    private String productName;
    
    @NotBlank
    private String modelType;
    
    @NotBlank
    private String colorType;

    private String packageQuantity;
    private String barCode;
    private ProductStatus status;    

    @NotBlank
    private String labelCode;

    @NotBlank
    private String modelCode;
    @NotBlank
    private String coatingCode;

    @NotBlank
    private String colorCode;

    @NotBlank
    private String sizeCode;

    @NotBlank
    private String graphicCode;

    @NotBlank
    private String specialCode;
    
    private String remark;
}
