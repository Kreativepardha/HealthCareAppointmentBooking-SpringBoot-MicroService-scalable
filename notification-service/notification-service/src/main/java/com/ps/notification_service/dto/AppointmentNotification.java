package com.ps.notification_service.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AppointmentNotification {
        private UUID patientId;
        private UUID doctorId;
        private LocalDateTime appointmentDate;
//        private AppointmentStatus status;

}
