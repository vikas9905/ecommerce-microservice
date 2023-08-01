package com.truepromise.product.productservice.dto;

import com.truepromise.product.productservice.model.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.util.List;

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
