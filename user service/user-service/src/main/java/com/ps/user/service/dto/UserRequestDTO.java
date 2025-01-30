package com.ps.user.service.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    @NotBlank(message = "Full name is required")
    private String fullName;
    @Email(message = "Invalid Email Format")
    @NotBlank(message = "Email is required")
    private String email;
    private String phone;
    private String Role;
}
