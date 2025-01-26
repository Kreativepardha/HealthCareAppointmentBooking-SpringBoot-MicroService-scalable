package com.ps.user.service.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull(message = "username is required")
    private String fullName;

    @NonNull(message = "email is required")
    private String email;

    private String role;

    private String phone;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



}
