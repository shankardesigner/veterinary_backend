package com.shankardesigner.poudelveterinary.controller;

import com.shankardesigner.poudelveterinary.customValidation.BindErrorService;
import com.shankardesigner.poudelveterinary.dto.VendorDto;
import com.shankardesigner.poudelveterinary.serviceImplimentatnion.VendorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class VendorController {
    @Autowired
    private VendorServiceImpl vendorService;

    @PostMapping("/saveVendor")
    public ResponseEntity<?> saveVendor(@RequestBody @Valid VendorDto vendorDto, BindingResult result) {
        if(result.hasErrors()) {
            return BindErrorService.setCustomErrors(result);
        }
        return new ResponseEntity<>(vendorService.saveInfo(vendorDto),HttpStatus.CREATED);
    }

    @GetMapping("/getAllVendors")
    public ResponseEntity<List<VendorDto>> getAllVendors() {
        return new ResponseEntity<List<VendorDto>>(vendorService.getAllInfo(),HttpStatus.OK);
    }
}
