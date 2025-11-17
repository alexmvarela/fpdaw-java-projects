package com.iesrodeira.utils;

public class CancelException extends Exception {

    // Constructor sin argumentos
    public CancelException() {
        super();
    }

    // Constructor con mensaje
    public CancelException(String message) {
        super(message);
    }
}