package com.ps.Health_service.service;

import com.ps.Health_service.dto.DoctorRequestDTO;
import com.ps.Health_service.dto.DoctorResponseDTO;
import com.ps.Health_service.exception.DoctorException;
import com.ps.Health_service.modal.Doctor;
import com.ps.Health_service.modal.Hospital;
import com.ps.Health_service.modal.Specialty;
import com.ps.Health_service.repository.DoctorRepository;
import com.ps.Health_service.repository.HospitalRepository;
import com.ps.Health_service.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepository doctorRepository;
    private final SpecialtyRepository specialtyRepository;
    private final HospitalRepository hospitalRepository;


    @Override
    public DoctorResponseDTO registerDoctor(DoctorRequestDTO doctorRequestDTO) throws DoctorException {
        Specialty specialty = specialtyRepository.findById(doctorRequestDTO.getSpecialtyId())
                .orElseThrow(() -> new DoctorException("Specialty not found"));

        Hospital hospital = hospitalRepository.findById(doctorRequestDTO.getHospitalId())
                .orElseThrow(() -> new DoctorException("Hospital not found"));

        Doctor doctor = new Doctor();
        doctor.setId(doctorRequestDTO.getId());
        doctor.setFullName(doctorRequestDTO.getFullName());
        doctor.setSpecialty(specialty);
        doctor.setHospital(hospital);
        doctor.setExperience(doctorRequestDTO.getExperience());
        doctor.setAvailable(doctorRequestDTO.isAvailable());
        doctorRepository.save(doctor);
    return mapToResponseDTO(doctor);
    }

    @Override
    public DoctorResponseDTO getDoctorById(UUID id) throws DoctorException {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorException("Doctor Not Found"));
        return mapToResponseDTO(doctor);
    }

    @Override
    public List<DoctorResponseDTO> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDoctor(UUID id) throws DoctorException{
        if(!doctorRepository.existsById(id)) {
            throw new DoctorException("Doctor does not exist");
        }
        doctorRepository.deleteById(id);
    }

    private DoctorResponseDTO mapToResponseDTO(Doctor doctor) {
        DoctorResponseDTO dto = new DoctorResponseDTO();
        dto.setId(doctor.getId());
        dto.setFullName(doctor.getFullName());
        dto.setSpecialty(doctor.getSpecialty().getName());
        dto.setHospital(doctor.getHospital().getName());
        dto.setExperience(doctor.getExperience());
        dto.setAvailable(doctor.isAvailable());
        return  dto;
    }

}