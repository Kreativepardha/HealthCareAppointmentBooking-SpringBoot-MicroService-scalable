package com.ps.user.service.Controller;


import com.ps.user.service.modal.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/users")
    public User getUser() {
        User user = new User();
         user.setEmail("testUser@gmail.com");
        user.setFullName("Test User");
        user.setPhone("281973921");
        user.setRole("customer");
    return user;
    }
}
