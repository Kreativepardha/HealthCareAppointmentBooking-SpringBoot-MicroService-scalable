package com.ps.Health_service.repository;

import com.ps.Health_service.modal.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
