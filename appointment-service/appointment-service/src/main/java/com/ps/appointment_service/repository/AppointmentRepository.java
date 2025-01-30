package com.ps.appointment_service.repository;

import com.ps.appointment_service.modal.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    List<Appointment> findByDoctorIdAndAppointmentDate(UUID doctorId, String appointmentDate);
}
