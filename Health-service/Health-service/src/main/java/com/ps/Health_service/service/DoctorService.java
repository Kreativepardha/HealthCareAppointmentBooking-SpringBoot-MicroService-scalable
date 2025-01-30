package com.ps.Health_service.service;

import com.ps.Health_service.dto.DoctorRequestDTO;
import com.ps.Health_service.dto.DoctorResponseDTO;
import com.ps.Health_service.exception.DoctorException;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
    DoctorResponseDTO registerDoctor(DoctorRequestDTO doctorRequestDTO) throws DoctorException;
    DoctorResponseDTO getDoctorById(UUID id) throws DoctorException;
    List<DoctorResponseDTO> getAllDoctors();
    void deleteDoctor(UUID id) throws DoctorException;
}
