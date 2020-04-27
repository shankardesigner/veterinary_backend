package com.shankardesigner.poudelveterinary.controller;

import com.shankardesigner.poudelveterinary.customValidation.BindErrorService;
import com.shankardesigner.poudelveterinary.dto.AddressDto;
import com.shankardesigner.poudelveterinary.serviceImplimentatnion.AddresServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class AddressController {

    @Autowired
    private AddresServiceImpl addresService;

    @PostMapping("/saveAddress")
    public ResponseEntity<?> saveAddress(@RequestBody @Valid AddressDto addressDto, BindingResult result) {
        if(result.hasErrors()) {
            return BindErrorService.setCustomErrors(result);
        }
        return new ResponseEntity<AddressDto>(addresService.saveInfo(addressDto), HttpStatus.OK);
    }

    @GetMapping("/getAllAddress")
    public ResponseEntity<List<AddressDto>> ageAllAddress() {
        return new ResponseEntity<>(addresService.getAllInfo() ,HttpStatus.OK);
    }
}
