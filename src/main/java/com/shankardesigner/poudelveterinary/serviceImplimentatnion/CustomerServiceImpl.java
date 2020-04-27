package com.shankardesigner.poudelveterinary.serviceImplimentatnion;

import com.shankardesigner.poudelveterinary.controller.FileUploadController;
import com.shankardesigner.poudelveterinary.dto.CustomerDto;
import com.shankardesigner.poudelveterinary.exceptions.CustomResponseEntityExceptionHandler;
import com.shankardesigner.poudelveterinary.model.Address;
import com.shankardesigner.poudelveterinary.model.Customer;
import com.shankardesigner.poudelveterinary.repositiory.AddressRepositiory;
import com.shankardesigner.poudelveterinary.repositiory.CustomerRepositiory;
import com.shankardesigner.poudelveterinary.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.shankardesigner.poudelveterinary.configuration.Const.GET_PATH;

@Service
public class CustomerServiceImpl implements GenericService<CustomerDto> {

    @Autowired
    private CustomerRepositiory customerRepositiory;

    @Autowired
    private AddressRepositiory addressRepositiory;

    @Autowired
    private FileUploadController fileUploadController;

    @Autowired
    private CustomResponseEntityExceptionHandler customResponseEntityExceptionHandler;

    @Override
    public CustomerDto saveInfo(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNo(customerDto.getMobileNo());
        customer.setDisplayPicture(customerDto.getDisplayPicture());
        Long tempAddressId = customerDto.getAddress();

        if(tempAddressId != null && tempAddressId != 0) {
            Address address = addressRepositiory.findById(tempAddressId).get();
            customer.setAddress(address);
        }
        customerRepositiory.save(customer);
        return customerDto;
    }

    @Override
    public CustomerDto updateInfo(CustomerDto customerDto) {
        return null;
    }

    @Override
    public boolean deleteInfo(long id) {
        customerRepositiory.deleteById(id);
        return true;
    }

    @Override
    public List<CustomerDto> getAllInfo() {
        List<Customer> allCustomer = customerRepositiory.findAll();
        return allCustomer.stream().map(item -> {
             CustomerDto customerDto = new CustomerDto();
             customerDto.setCustomerId(item.getCustId());
             customerDto.setName(item.getName());
             customerDto.setEmail(item.getEmail());
             customerDto.setMobileNo(item.getMobileNo());

             if(item.getAddress() != null) {
                 Long tempAddressId = item.getAddress().getAid();
                 customerDto.setAddress(tempAddressId);
             }
            customerDto.setDisplayPicture(GET_PATH+item.getDisplayPicture());
             customerDto.setCreatedAt(item.getCreatedAt().toString());

            return customerDto;
        }).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getInfoById(long id) {
        Customer customer = customerRepositiory.findById(id).get();
        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerId(customer.getCustId());
        customerDto.setDisplayPicture(GET_PATH+customer.getDisplayPicture());
        customerDto.setCreatedAt(customer.getCreatedAt().toString());
        customerDto.setAddress(customer.getAddress() != null ? customer.getAddress().getAid() : 0);
        customerDto.setEmail(customer.getEmail());
        customerDto.setName(customer.getName());
        customerDto.setMobileNo(customer.getMobileNo());
        return customerDto;
    }
}
