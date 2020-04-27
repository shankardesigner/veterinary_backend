package com.shankardesigner.poudelveterinary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistsExceptions extends RuntimeException {
    public EmailAlreadyExistsExceptions(String msg) {
        super(msg);
    }
}
