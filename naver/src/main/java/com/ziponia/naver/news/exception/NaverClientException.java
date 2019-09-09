package com.ziponia.naver.news.exception;

public class NaverClientException extends RuntimeException {
    public NaverClientException() {
        super();
    }

    public NaverClientException(String message) {
        super(message);
    }

    public NaverClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public NaverClientException(Throwable cause) {
        super(cause);
    }

    protected NaverClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
