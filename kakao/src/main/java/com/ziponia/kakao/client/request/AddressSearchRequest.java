package com.ziponia.kakao.client.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressSearchRequest {
    private String query;
    private Integer page;
    private Integer size;
}
