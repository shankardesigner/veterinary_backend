package com.shankardesigner.poudelveterinary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleEmailAlreadyExists(
            EmailAlreadyExistsExceptions ex) {
            EmailAlreadyExistsResponse emailAlreadyExistsResponse = new EmailAlreadyExistsResponse(ex.getMessage());
            return new ResponseEntity(emailAlreadyExistsResponse, HttpStatus.BAD_GATEWAY);
    }
}
