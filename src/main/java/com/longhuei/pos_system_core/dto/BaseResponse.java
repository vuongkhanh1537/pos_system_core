package com.longhuei.pos_system_core.dto;

import com.longhuei.pos_system_core.utils.StatusCode;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse<T> {
    private String code;
    private String message;
    private T wsResponse;

    public BaseResponse() {
        this.code = StatusCode.CODE_SUCCESS;
    }

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(String code, String message, T wsResponse) {
        this.code = code;
        this.message = message;
        this.wsResponse = wsResponse;
    }
}
