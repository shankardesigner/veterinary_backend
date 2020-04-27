package com.shankardesigner.poudelveterinary.controller;

import com.shankardesigner.poudelveterinary.customValidation.BindErrorService;
import com.shankardesigner.poudelveterinary.dto.ProductCatDto;
import com.shankardesigner.poudelveterinary.serviceImplimentatnion.ProductCatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class ProductCategoryController {
    @Autowired
    private ProductCatServiceImpl productCatService;

    @PostMapping("/saveProductCategory")
    public ResponseEntity<?> saveProductCategory(@RequestBody @Valid ProductCatDto productCatDto, BindingResult result) {

        if(result.hasErrors()) {
            return BindErrorService.setCustomErrors(result);
        };
        return new ResponseEntity<ProductCatDto>(productCatService.saveInfo(productCatDto), HttpStatus.OK);
    }

    @GetMapping("/getAllProductCategory")
    public ResponseEntity<List<ProductCatDto>> getAllProductCategory() {
        return new ResponseEntity<List<ProductCatDto>>(productCatService.getAllInfo(), HttpStatus.OK);
    }

    @GetMapping("/getProductCat/{pcatId}")
    public ResponseEntity<ProductCatDto> getOneCategory(@PathVariable long pcatId) {
        return new ResponseEntity<ProductCatDto>(productCatService.getInfoById(pcatId),HttpStatus.OK);
    }
}

