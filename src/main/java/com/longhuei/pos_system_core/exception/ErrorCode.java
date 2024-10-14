package com.longhuei.pos_system_core.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    NOT_FOUND(1000, "Not found"),
    INVALID_KEY(1001, "Uncategorized error"),
    USER_EXISTED(1002, "User existed"),
    USERNAME_INVALID(1003, "Username must be at least characters"),
    INVALID_PASSWORD(1004, "Password is wrong"),
    USER_NOT_EXISTED(1005, "User not existed"),
    UNAUTHENTICATED(1006, "Unauthenticated"),
    PRODUCT_CODE_NOT_EXISTED(1007, "Product code is not existed"),
    PRODUCT_EXISTED(1008, "Product is existed"),
    PRODUCT_NOT_EXISTED(1009, "Product not existed");

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;
    private final String message;
}
