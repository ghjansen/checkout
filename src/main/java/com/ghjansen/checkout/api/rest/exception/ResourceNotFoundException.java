package com.ghjansen.checkout.api.rest.exception;

public final class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super();
    }

    public ResourceNotFoundException(final Throwable cause){
        super(cause);
    }

    public ResourceNotFoundException(final String message){
        super(message);
    }

    public ResourceNotFoundException(final String message, final Throwable cause){
        super(message, cause);
    }

}
