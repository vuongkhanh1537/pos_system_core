package com.longhuei.pos_system_core.modules.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductSearchRequest {
    private String keyword;
    private boolean includeInactive;
}
