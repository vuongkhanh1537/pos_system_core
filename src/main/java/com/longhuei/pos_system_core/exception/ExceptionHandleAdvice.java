package com.longhuei.pos_system_core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.longhuei.pos_system_core.dto.BaseResponse;

@ControllerAdvice
public class ExceptionHandleAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BaseResponse<?>> handleResponseException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(BaseResponse.builder()
                .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .message(e.getMessage())
                .build());
    }

    @ExceptionHandler({ApplicationException.class})
    public ResponseEntity<BaseResponse<?>> handleResponseException(ApplicationException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(BaseResponse.builder()
                .code(String.valueOf(e.getCode()))
                .message(e.getMessage())
                .build());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<BaseResponse<?>> handleResponseException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(BaseResponse.builder()
                .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .message(e.getMessage())
                .build());
    }

    // @ExceptionHandler({JwtException.class})
    // public ResponseEntity<BaseResponse<?>> handleResponseException(JwtException e) {
    //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
    //         .body(BaseResponse.builder()
    //             .code(String.valueOf(HttpStatus.UNAUTHORIZED.value()))
    //             .message(e.getMessage())
    //             .build());
    // }
}
