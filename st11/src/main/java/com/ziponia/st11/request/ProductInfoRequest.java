package com.ziponia.st11.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductInfoRequest {

    @NonNull
    private String productCode;

    private String option;
}
