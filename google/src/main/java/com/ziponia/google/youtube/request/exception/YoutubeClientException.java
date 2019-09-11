package com.ziponia.google.youtube.request.exception;

public class YoutubeClientException extends RuntimeException {

    public YoutubeClientException() {
        super();
    }

    public YoutubeClientException(String message) {
        super(message);
    }

    public YoutubeClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public YoutubeClientException(Throwable cause) {
        super(cause);
    }

    protected YoutubeClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
