package com.ziponia.kakao.client.exception;

public class KakaoClientException extends RuntimeException {

    public KakaoClientException() {
        super("시스템 오류 https://devtalk.kakao.com/");
    }

    public KakaoClientException(String message) {
        super(message);
    }
}