package com.ps.Health_service.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DoctorRequestDTO {

    @NotNull(message = "Doctor ID is required")
    private UUID id;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotNull(message = "Specialty ID is required")
    private Long specialtyId;

    @NotNull(message = "Specialty ID is required")
    private Long hospitalId;

    @NotBlank(message = "Experience is required")
    private String experience;

    private boolean available;
}
