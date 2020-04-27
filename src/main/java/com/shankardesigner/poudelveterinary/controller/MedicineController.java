package com.shankardesigner.poudelveterinary.controller;

import com.shankardesigner.poudelveterinary.customValidation.BindErrorService;
import com.shankardesigner.poudelveterinary.dto.MedicineDto;
import com.shankardesigner.poudelveterinary.serviceImplimentatnion.MedicineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class MedicineController {
    @Autowired
    private MedicineServiceImpl medicineService;

    @PostMapping("/save-medicine")
    public ResponseEntity<?> saveMedicine(@RequestBody @Valid MedicineDto medicineDto, BindingResult result) {
        Map<String,String> err = new HashMap<String,String>();
        if(result.hasErrors()) {
            return BindErrorService.setCustomErrors(result);
        }
        return new ResponseEntity<MedicineDto>(medicineService.saveInfo(medicineDto), HttpStatus.OK);
    }
}
