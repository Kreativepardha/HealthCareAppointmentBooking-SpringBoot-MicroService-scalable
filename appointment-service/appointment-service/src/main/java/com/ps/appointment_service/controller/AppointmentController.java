package com.ps.appointment_service.controller;


import com.ps.appointment_service.dto.AppointmentDTO;
import com.ps.appointment_service.dto.CreateAppointmentRequest;
import com.ps.appointment_service.service.AppointmentService;
import com.ps.appointment_service.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/book")
    public ResponseEntity<AppointmentDTO> bookAppointment(@RequestBody CreateAppointmentRequest request) {
//       kafkaProducerService.sendAppointmentEvents(request.getAppointmentDate(),request.getPatientId(), request.getDoctorId());
        return ResponseEntity.ok(appointmentService.bookAppointment(request));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsForDoctor(@PathVariable UUID doctorID) {
        return ResponseEntity.ok(appointmentService.getAppointmentsForDoctor(doctorID));

    }


}
