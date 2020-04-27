package com.shankardesigner.poudelveterinary.controller;

import com.shankardesigner.poudelveterinary.customValidation.BindErrorService;
import com.shankardesigner.poudelveterinary.dto.ProductDto;
import com.shankardesigner.poudelveterinary.serviceImplimentatnion.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveProduct(@Valid @RequestBody ProductDto productDto, BindingResult result) {
        System.out.println(productDto);
        if(result.hasErrors()) {
            return BindErrorService.setCustomErrors(result);
        }
          return new ResponseEntity<ProductDto>(productService.saveInfo(productDto), HttpStatus.OK);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return new ResponseEntity<List<ProductDto>>(productService.getAllInfo(),HttpStatus.OK);
    }
}
