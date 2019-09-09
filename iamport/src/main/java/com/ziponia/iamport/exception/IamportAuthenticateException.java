package com.ziponia.iamport.exception;

public class IamportAuthenticateException extends IamportException {

    public IamportAuthenticateException() {
        super();
    }

    public IamportAuthenticateException(String message) {
        super(message);
    }

    public IamportAuthenticateException(String message, Throwable cause) {
        super(message, cause);
    }

    public IamportAuthenticateException(Throwable cause) {
        super(cause);
    }

    protected IamportAuthenticateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
