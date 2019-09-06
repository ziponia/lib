package com.ziponia.kakao.client.exception;

public class KakaoClientUnAuthorizeException extends RuntimeException {

    public KakaoClientUnAuthorizeException() {
        super("KAKAO 개발자센터에서 웹 KEY 를 확인 해주세요. [401]");
    }

    public KakaoClientUnAuthorizeException(String message) {
        super(message);
    }
}
