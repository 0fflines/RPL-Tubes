package com.example.tubesRPL.LoginController;

import com.example.tubesRPL.Users.User;
import com.example.tubesRPL.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/login")
    public String homelogin() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {
        // Cari pengguna berdasarkan email
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Login berhasil: cek role untuk menentukan halaman redirect
            switch (user.getRole().toLowerCase()) {
                case "koordinator":
                    return "/koor/home"; // Halaman untuk koordinator
                case "dosen":
                    return "/dosen/home"; // Halaman untuk dosen
                case "mahasiswa":
                    return "redirect:/mahasiswa"; // Halaman untuk mahasiswa
                default:
                    model.addAttribute("error", "Role tidak dikenali.");
                    return "login";
            }
        } else {
            // Login gagal: tampilkan pesan error
            model.addAttribute("error", "Email atau password salah.");
            return "login";
        }
    }
}