package com.shankardesigner.poudelveterinary.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProductCatDto {
    private long pcatId;

    @NotBlank(message = "product category can't be blank")
    private String productCategory;


}
