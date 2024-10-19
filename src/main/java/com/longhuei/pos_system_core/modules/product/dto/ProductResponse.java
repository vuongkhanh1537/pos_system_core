package com.longhuei.pos_system_core.modules.product.dto;

import java.time.LocalDate;

import com.longhuei.pos_system_core.modules.productCodeGen.dto.CoatingDto;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.ColorDto;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.GraphicDto;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.LabelDto;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.ModelDto;
import com.longhuei.pos_system_core.modules.productCodeGen.dto.SizeDto;
import com.longhuei.pos_system_core.utils.enums.ProductStatus;

import lombok.Data;

@Data
public class ProductResponse {
    private String productId;
    private String productName;
    private String modelType;
    private String colorType;
    private String packageQuantity;
    private String barCode;
    private ProductStatus status;    

    private LocalDate stopDate;
    private LocalDate resumeDate;

    private LabelDto label;
    private ModelDto model;
    private CoatingDto coating;
    private ColorDto color;
    private SizeDto size;
    private GraphicDto graphic;
    private String specialCode;
    
    private String remark;

    public ProductResponse(
        String productId, 
        String productName, 
        String modelType, 
        String colorType, 
        String packageQuantity, 
        String barCode, 
        ProductStatus status, 
        LocalDate stopDate, 
        LocalDate resumeDate, 
        String specialCode,
        String labelCode, String labelNameEN, String labelNameCHT,
        String modelCode, String modelNameEN, String modelNameCHT,
        String coatingCode, String coatingNameEN, String coatingNameCHT,
        String colorCode, String colorNameEN, String colorNameCHT,
        String sizeCode, String sizeNameEN, String sizeNameCHT,
        String graphicCode, String graphicNameEN, String graphicNameCHT,
        String remark
    ) {
        this.productId = productId;
        this.productName = productName;
        this.modelType = modelType;
        this.colorType = colorType;
        this.packageQuantity = packageQuantity;
        this.barCode = barCode;
        this.status = status;
        this.stopDate = stopDate;
        this.resumeDate = resumeDate;
        this.specialCode = specialCode;
        this.label = new LabelDto(labelCode, labelNameEN, labelNameCHT);
        this.model = new ModelDto(modelCode, modelNameEN, modelNameCHT);
        this.coating = new CoatingDto(coatingCode, coatingNameEN, coatingNameCHT);
        this.color = new ColorDto(colorCode, colorNameEN, colorNameCHT);
        this.size = new SizeDto(sizeCode, sizeNameEN, sizeNameCHT);
        this.graphic = new GraphicDto(graphicCode, graphicNameEN, graphicNameCHT);
        this.remark = remark;
    }
}
