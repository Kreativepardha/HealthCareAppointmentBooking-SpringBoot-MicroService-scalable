package com.ps.Health_service.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DoctorResponseDTO {

    private UUID id;
    private String fullName;
    private String specialty;
    private String hospital;
    private String experience;
    private boolean available;
}
