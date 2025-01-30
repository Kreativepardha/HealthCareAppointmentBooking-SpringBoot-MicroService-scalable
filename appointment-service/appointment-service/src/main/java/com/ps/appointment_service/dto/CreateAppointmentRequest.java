package com.ps.appointment_service.dto;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CreateAppointmentRequest {

    private UUID patientId;
    private UUID doctorId;
    private LocalDateTime appointmentDate;
}
