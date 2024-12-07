package com.example.tubesRPL.Dosen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    // GET method untuk menampilkan halaman utama
    @GetMapping("/dosen")
    public String homePage(Model model) {
        model.addAttribute("email", "user@example.com");
        model.addAttribute("role", "Guest");
        return "dosen/home"; // Nama file HTML di dalam folder templates/dosen/home.html
    }

    // POST method untuk menangani form profile
    @PostMapping("/profile")
    public String handleProfile(@RequestParam("email") String email,
            @RequestParam("role") String role,
            Model model) {
        model.addAttribute("email", email);
        model.addAttribute("role", role);
        return "dosen/profile"; // Nama file HTML untuk profile
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

    @GetMapping("/bap")
    public String bap(){
        return "bapSidang.html";
    }
}
