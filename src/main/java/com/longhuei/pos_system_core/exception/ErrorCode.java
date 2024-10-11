package com.longhuei.pos_system_core.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    INVALID_KEY(1001, "Uncategorized error"),
    USER_EXISTED(1002, "User existed"),
    USERNAME_INVALID(1003, "Username must be at least characters"),
    INVALID_PASSWORD(1004, "Password is wrong"),
    USER_NOT_EXISTED(1005, "User not existed"),
    UNAUTHENTICATED(1006, "Unauthenticated"),
    PRODUCT_CODE_NOT_EXISTED(1007, "Product code is not exist"),
    PRODUCT_NOT_EXISTED(1008, "Product not existed"),
    WAREHOUSE_NOT_EXISTED(1009, "Warehouse not existed"),
    SUPPLIER_NOT_EXISTED(1010, "Supplier not existed"),
    SALER_NOT_EXISTED(1011, "Saler not existed");

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;
    private final String message;
}
