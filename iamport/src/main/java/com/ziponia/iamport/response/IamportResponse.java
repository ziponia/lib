package com.ziponia.iamport.response;

import lombok.Value;

@Value
public class IamportResponse<T> {

    private Integer code;
    private String message;
    private T response;
}
