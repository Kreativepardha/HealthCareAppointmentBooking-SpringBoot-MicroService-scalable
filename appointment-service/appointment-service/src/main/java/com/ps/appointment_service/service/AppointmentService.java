package com.ps.appointment_service.service;


import com.ps.appointment_service.dto.AppointmentDTO;
import com.ps.appointment_service.dto.CreateAppointmentRequest;
import com.ps.appointment_service.modal.Appointment;
import com.ps.appointment_service.modal.AppointmentStatus;
import com.ps.appointment_service.repository.AppointmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;


    @Transactional
    public AppointmentDTO bookAppointment(CreateAppointmentRequest request) {
        List<Appointment> existingAppointments = appointmentRepository.findByDoctorIdAndAppointmentDate(
                request.getDoctorId(), request.getAppointmentDate().toString()
        );
        if (!existingAppointments.isEmpty()) {
            throw new RuntimeException("Doctor is already booked at this time.");
        }

        Appointment appointment = Appointment.builder()
                .patientId(request.getPatientId())
                .doctorId(request.getDoctorId())
                .appointmentDate(request.getAppointmentDate())
                .status(AppointmentStatus.PENDING)
                .build();

        appointmentRepository.save(appointment);

        return mapToDTO(appointment);
    }


    public List<AppointmentDTO> getAppointmentsForDoctor(UUID doctorId) {
        return appointmentRepository.findByDoctorIdAndAppointmentDate(doctorId, "")
                .stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private AppointmentDTO mapToDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setPatientId(appointment.getPatientId());
        dto.setDoctorId(appointment.getDoctorId());
        dto.setAppointmentDate(appointment.getAppointmentDate());
        dto.setStatus(appointment.getStatus());
        return dto;


    }
}