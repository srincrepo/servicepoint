package com.sr.servicepoint.carrier.exception;

public class CarrierNotFoundException extends Exception {

    private static final String ERROR_MESSAGE = "Carrier can not be found";

    public CarrierNotFoundException() {
        super(ERROR_MESSAGE);
    }
}