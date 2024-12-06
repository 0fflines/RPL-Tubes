package com.example.tubesRPL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "/login";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "/register";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {
        // Add login authentication logic here (e.g., check user credentials)
        if (email.equals("admin@example.com") && password.equals("password")) {
            model.addAttribute("email", email);
            model.addAttribute("role", "Admin");
            return "redirect:/profile"; // Redirect to profile page on successful login
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login"; // Return to login page with an error
        }
    }
}
