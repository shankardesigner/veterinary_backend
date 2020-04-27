package com.shankardesigner.poudelveterinary.serviceImplimentatnion;

import com.shankardesigner.poudelveterinary.dto.MedicineDto;
import com.shankardesigner.poudelveterinary.model.Medicine;
import com.shankardesigner.poudelveterinary.repositiory.MedicineRepositiory;
import com.shankardesigner.poudelveterinary.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements GenericService<MedicineDto> {
    @Autowired
    private MedicineRepositiory medicineRepositiory;

    @Override
    public MedicineDto saveInfo(MedicineDto medicineDto) {
        Medicine medicine = new Medicine();
        medicine.setMedicineName(medicineDto.getMedicineName());
        medicine.setPrice(medicineDto.getPrice());
        medicineRepositiory.save(medicine);
        return medicineDto;
    }

    @Override
    public MedicineDto updateInfo(MedicineDto medicineDto) {
        return null;
    }

    @Override
    public boolean deleteInfo(long id) {
        return false;
    }

    @Override
    public List<MedicineDto> getAllInfo() {
        return null;
    }

    @Override
    public MedicineDto getInfoById(long id) {
        return null;
    }
}
