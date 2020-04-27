package com.shankardesigner.poudelveterinary.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto {

    private long productId;

    @NotBlank(message = "Product name can't be blank")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    private String productName;

    @NotBlank(message = "Product description can't be blank")
    private String productDesc;

//    @NotBlank(message = "Please set the product price")
    @NotNull(message = "Please set the product price")
    //@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    private float price;

    @NotBlank(message = "Product image can't be blank")
    private String imagePath;

    @NotNull(message = "Vendor can't be empty")
    private long vendor;

    @NotNull(message = "Please specify the product category")
    private long productCat;
}
