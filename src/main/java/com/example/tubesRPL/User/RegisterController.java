package com.example.tubesRPL.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String register(@RequestBody User user) {
        user.setRole("mahasiswa"); // Default role
        userRepository.save(user);
        return "Registration successful!";
    }
}
