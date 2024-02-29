package com.john.cacapalindromo.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
/**
 * @author john
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends CoreException {

    @Serial
    private static final long serialVersionUID = 1L;

    public BadRequestException(String message) {
        super(message);
    }

}