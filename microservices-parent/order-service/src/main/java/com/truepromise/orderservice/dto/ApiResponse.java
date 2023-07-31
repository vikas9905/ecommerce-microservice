package com.truepromise.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {

    private Object data ;
    private final int status;
    private final String message;
    private String error ;

    public ApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }


}
