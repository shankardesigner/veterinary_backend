package com.shankardesigner.poudelveterinary.customValidation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class BindErrorService {

    public static ResponseEntity<Map<String, String>> setCustomErrors(BindingResult result) {
        Map<String, String > customErrors = new HashMap<String, String>();
        result.getFieldErrors().forEach(fieldError -> {
            customErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return new ResponseEntity<Map<String, String>>(customErrors, HttpStatus.BAD_REQUEST);
    }
}
