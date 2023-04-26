package com.example.accesskeybackend.exception;

public class IPv6SupportException extends BaseException {
    public IPv6SupportException() {
    }

    public IPv6SupportException(String message) {
        super(message);
    }

    public IPv6SupportException(String message, Throwable cause) {
        super(message, cause);
    }

    public IPv6SupportException(Throwable cause) {
        super(cause);
    }

    public IPv6SupportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
