package com.ziponia.kakao.client.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressSearchRequest {
    private String query;
    private Integer page;
    private Integer size;
}
