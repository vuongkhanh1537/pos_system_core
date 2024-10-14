package com.longhuei.pos_system_core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ApplicationException extends RuntimeException {
    private int code;
    private String message;

    public ApplicationException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public ApplicationException(int code) {
        this.code = code;
    }

    public ApplicationException(String message) {
        this.message = message;
    }
}
