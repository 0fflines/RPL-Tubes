package com.example.tubesRPL.Koordinator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KoordinatorPage {

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

    @GetMapping("/home-bobot")
    public String komponenNilai(@RequestParam("email") String email, Model model) {
        // Add attributes to model
        model.addAttribute("email", "user@example.com");
        model.addAttribute("role", "Penguji");
        return "koor/bobot-nilai";
    }

    @GetMapping("/config-bobot")
    public String addKomponenNilai(@RequestParam("email") String email, Model model) {
        // Add attributes to model
        model.addAttribute("email", "user@example.com");
        model.addAttribute("role", "Penguji");
        return "koor/change-nilai";
    }
}
