package com.ziponia.iamport.exception;

public class IamportException extends RuntimeException {

    public IamportException() {
        super();
    }

    public IamportException(String message) {
        super(message);
    }

    public IamportException(String message, Throwable cause) {
        super(message, cause);
    }

    public IamportException(Throwable cause) {
        super(cause);
    }

    protected IamportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
