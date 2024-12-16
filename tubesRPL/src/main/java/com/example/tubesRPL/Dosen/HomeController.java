package com.example.tubesRPL.Dosen;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    // GET method untuk menampilkan halaman utama
    @PreAuthorize("hasRole('dosen')")
    @GetMapping("/dosen")
    public String homePage(Model model) {
        model.addAttribute("email", "user@example.com");
        model.addAttribute("role", "Guest");
        return "dosen/home"; // Nama file HTML di dalam folder templates/dosen/home.html
    }

    @GetMapping("/penguji")
    public String homePenguji() {
        return "dosen/penguji";
    }

    @GetMapping("/pembimbing")
    public String homePembimbing() {
        return "dosen/pembimbing";
    }

    @GetMapping("/profileDosenPenguji")
    public String profilePenguji() {
        return "dosen/profileDosenPenguji";
    }

    @GetMapping("/profileDosenPembimbing")
    public String profilePembimbing() {
        return "dosen/profileDosenPembimbing";
    }

    @GetMapping("/profileKoordinator")
    public String profileKoordinator() {
        return "koor/profileKoordinator";
    }

    @GetMapping("/profileMahasiswa")
    public String profileMahasiswa() {
        return "mahasiswa/profileMahasiswa";
    }

    // POST method untuk menangani form profile
    @PostMapping("/profile")
    public String handleProfile(@RequestParam("email") String email,
            @RequestParam("role") String role,
            Model model) {
        model.addAttribute("email", email);
        model.addAttribute("role", role);
        return "dosen/profileDosen"; // Nama file HTML untuk profile
    }

    // POST method untuk memilih role penguji
    @PostMapping("/select-penguji")
    public String selectPenguji(@RequestParam("email") String email, Model model) {
        model.addAttribute("email", email);
        model.addAttribute("role", "Penguji");
        return "dosen/penguji"; // Nama file HTML untuk dashboard penguji
    }

    // POST method untuk memilih role pembimbing
    @PostMapping("/select-pembimbing")
    public String selectPembimbing(@RequestParam("email") String email, Model model) {
        model.addAttribute("email", email);
        model.addAttribute("role", "Pembimbing");
        return "dosen/pembimbing"; // Nama file HTML untuk dashboard pembimbing
    }

    @GetMapping("/home")
    public String backToHomePage(Model model) {
        model.addAttribute("email", "user@example.com");
        model.addAttribute("role", "Guest");
        return "dosen/home";
    }

    @GetMapping("/bapSidang")
    public String getBAP(){
        return "bapSidang";
    }
}
