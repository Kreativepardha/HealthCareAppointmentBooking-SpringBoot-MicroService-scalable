package com.ps.appointment_service.dto;


import com.ps.appointment_service.modal.AppointmentStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AppointmentDTO {

    private UUID id;
    private UUID patientId;
    private UUID doctorId;
    private LocalDateTime appointmentDate;
    private AppointmentStatus status;
}
