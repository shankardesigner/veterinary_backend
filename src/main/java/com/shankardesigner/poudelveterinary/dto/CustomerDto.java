package com.shankardesigner.poudelveterinary.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto {
    private long customerId;

    @NotBlank(message = "Please enter the full name")
    private String name;

    @Email(message = "Please provide the correct email")
    @NotBlank(message = "Email can't be empty")
    private String email;

    @NotBlank(message = "Please provide the mobile number")
//    @Pattern(regexp = "")
    private String mobileNo;

    @NotBlank(message = "please provide the display picture")
    private String displayPicture;

    @NotNull(message = "provide your address")
    private long address;

    private String createdAt;

}
