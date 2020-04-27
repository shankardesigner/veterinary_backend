package com.shankardesigner.poudelveterinary.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MedicineDto {
    private long mid;

    @NotBlank(message = "medicine name can't be empty")
    private String medicineName;

    private long price;
}
