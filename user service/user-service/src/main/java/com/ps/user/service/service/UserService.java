package com.ps.user.service.service;


import com.ps.user.service.dto.UserRequestDTO;
import com.ps.user.service.dto.UserResponseDTO;
import com.ps.user.service.exception.UserException;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    UserResponseDTO getUserById(Long id) throws UserException;
    List<UserResponseDTO> getAllUsers();
    void deleteUser(Long id) throws UserException;
    UserResponseDTO updateUser(Long id, @Valid UserRequestDTO userRequestDTO) throws  UserException;
    UserResponseDTO findByEmail(String email) throws  UserException;
}
