package com.shankardesigner.poudelveterinary.serviceImplimentatnion;

import com.shankardesigner.poudelveterinary.dto.AddressDto;
import com.shankardesigner.poudelveterinary.model.Address;
import com.shankardesigner.poudelveterinary.repositiory.AddressRepositiory;
import com.shankardesigner.poudelveterinary.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddresServiceImpl implements GenericService<AddressDto> {

    @Autowired
    private AddressRepositiory addressRepositiory;

    @Override
    public AddressDto saveInfo(AddressDto addressDto) {

        Address address = new Address();
        address.setCountry(addressDto.getCountry());
        address.setState(addressDto.getState());
        address.setZone(addressDto.getZone());
        address.setDistrict(addressDto.getDistrict());
        address.setAddressLine1(addressDto.getAddressLine1());
        address.setAddressLine2(addressDto.getAddressLine2());
        addressRepositiory.save(address);
        return addressDto;
    }

    @Override
    public AddressDto updateInfo(AddressDto addressDto) {
        return null;
    }

    @Override
    public boolean deleteInfo(long id) {
        return false;
    }

    @Override
    public List<AddressDto> getAllInfo() {
        return addressRepositiory.findAll().stream().map(item -> {
            AddressDto addressDto = new AddressDto();
            addressDto.setCountry(item.getCountry());
            addressDto.setState(item.getState());
            addressDto.setZone(item.getZone());
            addressDto.setDistrict(item.getDistrict());
            addressDto.setAddressLine1(item.getAddressLine1());
            addressDto.setAddressLine2(item.getAddressLine2());
            return addressDto;
        }).collect(Collectors.toList());
    }

    @Override
    public AddressDto getInfoById(long id) {
        Address addressById = addressRepositiory.findById(id).get();
        AddressDto addressDto = new AddressDto();
        addressDto.setCountry(addressById.getCountry());
        addressDto.setState(addressById.getState());
        addressDto.setZone(addressById.getZone());
        addressDto.setDistrict(addressById.getDistrict());
        addressDto.setAddressLine1(addressById.getAddressLine1());
        addressDto.setAddressLine2(addressById.getAddressLine2());
        return addressDto;
    }
}
