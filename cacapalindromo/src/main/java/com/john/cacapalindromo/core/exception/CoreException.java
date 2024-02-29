package com.john.cacapalindromo.core.exception;

import java.io.Serial;
/**
 * @author john
 */
public class CoreException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public CoreException(String message) {
        super(message);
    }

    public CoreException(String message, Throwable cause) {
        super(message, cause);
    }

}