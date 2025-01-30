package com.ps.user.service.service;


import com.ps.user.service.dto.UserRequestDTO;
import com.ps.user.service.dto.UserResponseDTO;
import com.ps.user.service.exception.UserException;
import com.ps.user.service.modal.User;
import com.ps.user.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

        if(userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()) {
            throw new UserException("User with EMAIL" + userRequestDTO.getEmail() + " already exists");
        }
        User user = new User();
        user.setFullName(userRequestDTO.getFullName());
        user.setEmail(userRequestDTO.getEmail());
        user.setRole(userRequestDTO.getRole());
        user.setPhone(userRequestDTO.getPhone());
        User savedUser = userRepository.save(user);
        return mapToResponseDTO(savedUser);
    }

    private UserResponseDTO mapToResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        return dto;
    }

    @Override
    public UserResponseDTO getUserById(Long id) throws UserException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found with id::"+ id));
        return mapToResponseDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)) {
            throw new UserException("User does not exists with ID: " + id);
        }
        userRepository.deleteById(id);
    }


    @Override
    public UserResponseDTO updateUser(Long id,UserRequestDTO userRequestDTO) {
        User existingUser = userRepository.findById(id)
                        .orElseThrow(() -> new UserException("User not found with ID"+ id));

                    existingUser.setFullName(userRequestDTO.getFullName());
                    existingUser.setEmail(userRequestDTO.getEmail());
                    existingUser.setRole(userRequestDTO.getRole());
                    existingUser.setPhone(userRequestDTO.getPhone());
    User updatedUser = userRepository.save(existingUser);
    return mapToResponseDTO(updatedUser);

    }
    @Override
    public UserResponseDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->  new UserException("User not found with email" + email));
        return mapToResponseDTO(user);
    }
}
