package com.example.tubesRPL.Mahasiswa;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class MahasiswaController {

    @PreAuthorize("hasRole('mahasiswa')")
    @GetMapping("/mahasiswa")
    public String showMahasiswaPage(Model model) {
        // Pastikan atribut model ini sesuai dengan template
        model.addAttribute("nama", "Kevin Halim");
        model.addAttribute("email", "kevin.halim@example.com");
        model.addAttribute("role", "Mahasiswa");
        return "/mahasiswa/index"; // Pastikan file ini ada
    }

    @GetMapping("/profile")
    public String viewProfile() {
        return "profile"; // Pastikan file profile.html ada di templates/
    }
}