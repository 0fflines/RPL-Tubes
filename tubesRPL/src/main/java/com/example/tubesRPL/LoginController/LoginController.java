package com.example.tubesRPL.LoginController;

import com.example.tubesRPL.Users.User;
import com.example.tubesRPL.Users.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/login")
    public String homelogin(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("userdata");
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model, HttpSession httpSession) {
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            httpSession.setAttribute("userdata", user);
            model.addAttribute("user", user);
            switch (user.getRole().toLowerCase()) {
                case "koordinator":
                    return "/koor/home";
                case "dosen":
                    return "redirect:/dosen";
                case "mahasiswa":
                    return "redirect:/mahasiswa";
                default:
                    model.addAttribute("error", "Role tidak dikenali.");
                    return "login";
            }
        } else {
            model.addAttribute("error", "Email atau password salah.");
            return "login";
        }
    }

    @GetMapping("/userdata")
    @ResponseBody
    public User getUserData(HttpSession httpSession) {
        return (User) httpSession.getAttribute("userdata");
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/login";
    }
}
