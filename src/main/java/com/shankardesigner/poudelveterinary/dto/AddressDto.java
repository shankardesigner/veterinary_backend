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
public class AddressDto {

    @NotBlank(message = "Country can't be blank")
    private String country;

    @NotBlank(message = "State can't be blank")
    private String state;

    @NotBlank(message = "Zone can't be blank")
    private String zone;

    @NotBlank(message = "District can't be blank")
    private String district;

    @NotBlank(message = "Please add Addressline1")
    private String addressLine1;

    private String addressLine2;
}
