package com.example.tubesRPL.Mahasiswa;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MahasiswaController {

    @PreAuthorize("hasRole('mahasiswa')")
    @GetMapping("/mahasiswa")
    public String viewMahasiswa() {
        return "/mahasiswa/index"; // Mengarah ke file mahasiswa.html di folder templates
    }

    @GetMapping("/profile")
    public String viewProfile() {
        return "/profile"; // Mengarah ke file profile.html di folder templates
    }
}