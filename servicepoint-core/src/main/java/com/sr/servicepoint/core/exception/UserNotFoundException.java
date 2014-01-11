package com.sr.servicepoint.core.exception;

public class UserNotFoundException extends Exception {

    private static final String ERROR_MESSAGE = "User can not be found";

    public UserNotFoundException() {
        super(ERROR_MESSAGE);
    }

}
