package com.shankardesigner.poudelveterinary.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class VendorDto {

    private long vendorId;

    @NotBlank(message = "vendor name can't be empty")
    private String vendorName;
}
