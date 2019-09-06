package com.ziponia.kakao.client.exception;

public class KakaoClientBadRequestException extends RuntimeException {

    public KakaoClientBadRequestException() {
        super("잘못 된 요청입니다. code [400]");
    }

    public KakaoClientBadRequestException(String message) {
        super(message);
    }
}
