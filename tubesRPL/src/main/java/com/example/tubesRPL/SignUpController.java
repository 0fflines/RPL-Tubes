package com.example.tubesRPL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class SignUpController {

    @GetMapping("/signup")
    public String showSignUpForm() {
        return "/signup"; // Return the sign up HTML page (signup.html)
    }

    @PostMapping("/signup")
    public String handleSignUp(@RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {
        // Add sign-up logic (e.g., save user to database)
        model.addAttribute("email", email);
        model.addAttribute("role", "User"); // Set a default role
        return "redirect:/profile"; // Redirect to profile page after successful sign up
    }
}
