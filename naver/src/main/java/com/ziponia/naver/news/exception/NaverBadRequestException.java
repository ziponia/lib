package com.ziponia.naver.news.exception;

public class NaverBadRequestException extends NaverClientException {

    public NaverBadRequestException() {
        super();
    }

    public NaverBadRequestException(String message) {
        super(message);
    }

    public NaverBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public NaverBadRequestException(Throwable cause) {
        super(cause);
    }

    protected NaverBadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
