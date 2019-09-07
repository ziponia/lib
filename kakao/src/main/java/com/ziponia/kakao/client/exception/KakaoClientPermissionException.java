package com.ziponia.kakao.client.exception;

public class KakaoClientPermissionException extends RuntimeException{

    public KakaoClientPermissionException() {
        super("호출 권한이 없습니다. 참조 https://developers.kakao.com/docs/restapi/quick-reference#응답-코드");
    }

    public KakaoClientPermissionException(String message) {
        super(message);
    }
}
