package com.ghjansen.checkout.api.rest.exception;

public final class ResourceConflictException extends Throwable {

    public ResourceConflictException() {
    }

    public ResourceConflictException(String message) {
        super(message);
    }

    public ResourceConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceConflictException(Throwable cause) {
        super(cause);
    }
}
