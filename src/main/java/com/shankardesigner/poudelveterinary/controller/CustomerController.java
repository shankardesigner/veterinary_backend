package com.shankardesigner.poudelveterinary.controller;

import com.shankardesigner.poudelveterinary.customValidation.BindErrorService;
import com.shankardesigner.poudelveterinary.dto.CustomerDto;
import com.shankardesigner.poudelveterinary.repositiory.CustomerRepositiory;
import com.shankardesigner.poudelveterinary.serviceImplimentatnion.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CustomerRepositiory customerRepositiory;

    @PostMapping("/saveCustomer")
    public ResponseEntity<?> saveCustomer(@RequestBody @Valid CustomerDto customer,
                                          BindingResult result){
        if(result.hasErrors()) {
            return BindErrorService.setCustomErrors(result);
        }
        if(customerRepositiory.findByEmail(customer.getEmail()) != null) {
            Map<String, String> errMsg = new HashMap<>();
            errMsg.put("email","Email already exists.");
            return new ResponseEntity<Map<String,String>>(errMsg,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<CustomerDto>(customerService.saveInfo(customer),HttpStatus.OK);
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<CustomerDto>> getAllProducts() {
        return new ResponseEntity<List<CustomerDto>>(customerService.getAllInfo(),HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<?> getOneCustomer(@PathVariable long id) {
        if(!customerRepositiory.findById(id).isPresent()) {
            Map<String, String> errMsg = new HashMap<>();
            errMsg.put("customer","Sorry requested customer doesn't exist.");
            return new ResponseEntity<Map<String,String>>(errMsg,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<CustomerDto>(customerService.getInfoById(id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable long id) {
        Map<String, String> msg = new HashMap<String,String>();
        boolean deleteCustomer = customerService.deleteInfo(id);
        if(deleteCustomer) {
            msg.put("response","Customer deleted successfully.");
            return new ResponseEntity<Map<String,String>>(msg,HttpStatus.OK);
        }else{
            msg.put("response","Can't Delete the customer");
            return new ResponseEntity<Map<String,String>>(msg,HttpStatus.BAD_REQUEST);
        }
    }
}
