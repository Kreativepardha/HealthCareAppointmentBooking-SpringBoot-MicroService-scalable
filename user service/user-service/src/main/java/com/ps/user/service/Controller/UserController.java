package com.ps.user.service.Controller;

import com.ps.user.service.dto.UserRequestDTO;
import com.ps.user.service.dto.UserResponseDTO;
import com.ps.user.service.exception.UserException;
import com.ps.user.service.modal.User;
import com.ps.user.service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
            return ResponseEntity.ok(userService.createUser(userRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws UserException {
        userService.deleteUser(id);
        return ResponseEntity.ok("User Deleted Successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser (
            @PathVariable Long id,
            @Valid @RequestBody UserRequestDTO userRequestDTO
    ) throws UserException{
        return ResponseEntity.ok(userService.updateUser(id, userRequestDTO));
    }

}
