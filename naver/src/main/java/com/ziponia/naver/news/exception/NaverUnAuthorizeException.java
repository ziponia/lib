package com.ziponia.naver.news.exception;

public class NaverUnAuthorizeException extends NaverClientException {
    public NaverUnAuthorizeException() {
        super();
    }

    public NaverUnAuthorizeException(String message) {
        super(message);
    }

    public NaverUnAuthorizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NaverUnAuthorizeException(Throwable cause) {
        super(cause);
    }

    protected NaverUnAuthorizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
