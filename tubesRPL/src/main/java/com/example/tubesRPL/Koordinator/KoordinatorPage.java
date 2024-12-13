package com.example.tubesRPL.Koordinator;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KoordinatorPage {

    @PreAuthorize("hasRole('koordinator')")
    @GetMapping("/koordinator")
    public String openKoordiantorPage(Model model) {
        // Data dummy untuk email dan role yang akan ditampilkan di halaman
        String email = "user@example.com";
        String role = "Penguji";

        // Menambahkan data ke model agar bisa diakses di template HTML
        model.addAttribute("email", email);
        model.addAttribute("role", role);

        // Mengembalikan nama template untuk menampilkan halaman
        return "/koor/home"; // Halaman ini merujuk ke penguji.html di folder src/main/resources/templates
    }

    @GetMapping("/bobot-nilai")
    public String homeBobot() {
        return "koor/bobot-nilai";
    }

    @GetMapping("/config-bobot")
    public String homeConfig() {
        return "koor/change-nilai";
    }

    @GetMapping("/create")
    public String homeCreate() {
        return "koor/create";
    }
}
