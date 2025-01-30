package com.ps.Health_service.modal;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "doctors")
public class Doctor {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "specialty_id", nullable = false)
    private Specialty specialty;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @Column(nullable = false)
    private String experience;

    @Column(nullable = false)
    private boolean available;
}
