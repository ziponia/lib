package com.ziponia.iamport;

import lombok.Value;

@Value
public class AccessToken {

    /**
     * 반환된 access token
     */
    private String access_token;

    /**
     * 현재 시간
     */
    private Integer now;

    /**
     * 토큰이 만료 될 시간
     */
    private Integer expired_at;
}
