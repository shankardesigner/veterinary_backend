package com.shankardesigner.poudelveterinary.serviceImplimentatnion;

import com.shankardesigner.poudelveterinary.dto.VendorDto;
import com.shankardesigner.poudelveterinary.model.Vendor;
import com.shankardesigner.poudelveterinary.repositiory.VendorRepositiory;
import com.shankardesigner.poudelveterinary.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements GenericService<VendorDto> {

    @Autowired
    private VendorRepositiory vendorRepositiory;

    @Override
    public VendorDto saveInfo(VendorDto vendorDto) {
        Vendor vendor = new Vendor();
        vendor.setVendorName(vendorDto.getVendorName());
        vendor.setCreatedAt(new Date());
        vendorRepositiory.save(vendor);
        return vendorDto;
    }

    @Override
    public VendorDto updateInfo(VendorDto vendorDto) {
        return null;
    }

    @Override
    public boolean deleteInfo(long id) {
        return false;
    }

    @Override
    public List<VendorDto> getAllInfo() {
        List<Vendor> allVendors = vendorRepositiory.findAll();
        return allVendors.stream().map(vendor -> {
            VendorDto vendorDto = new VendorDto();
            vendorDto.setVendorId(vendor.getVid());
            vendorDto.setVendorName(vendor.getVendorName());
            return vendorDto;
        }).collect(Collectors.toList());
    }

    @Override
    public VendorDto getInfoById(long id) {
        return null;
    }
}
