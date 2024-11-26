package com.example.tubesRPL.Koordinator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KoordinatorController {

    // Endpoint untuk halaman penguji
    @GetMapping("/koordinator")
    public String koordinatorPage(@RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "role", required = false) String role,
            Model model) {
        // Validasi jika email atau role tidak ada
        if (email == null || role == null) {
            return "redirect:/error"; // Redirect ke halaman error custom
        }

        model.addAttribute("email", email);
        model.addAttribute("role", role);
        return "/koor/home";
    }

    // Endpoint untuk halaman create TA
    @GetMapping("/create")
    public String createPage(@RequestParam("email") String email,
            @RequestParam("role") String role,
            Model model) {
        // Kirim data email dan role ke halaman create TA
        model.addAttribute("email", email);
        model.addAttribute("role", role);
        return "create"; // Nama file HTML halaman create TA
    }

    // Endpoint untuk menyimpan data TA dari form
    @PostMapping("/save-ta")
    public String saveTA(@RequestParam("name") String name,
            @RequestParam("judul") String judul,
            @RequestParam("jenis") String jenis,
            @RequestParam("tempat") String tempat,
            @RequestParam("penguji-1") String penguji1,
            @RequestParam("penguji-2") String penguji2,
            @RequestParam("pembimbing-u") String pembimbingU,
            @RequestParam("pembimbing-p") String pembimbingP,
            @RequestParam("email") String email,
            @RequestParam("role") String role,
            Model model) {
        // Simpan data TA di database (implementasi terserah, misalnya menggunakan
        // service)
        System.out.println("Menyimpan data TA:");
        System.out.println("Nama: " + name);
        System.out.println("Judul: " + judul);
        System.out.println("Jenis: " + jenis);
        System.out.println("Tempat: " + tempat);
        System.out.println("Penguji 1: " + penguji1);
        System.out.println("Penguji 2: " + penguji2);
        System.out.println("Pembimbing Utama: " + pembimbingU);
        System.out.println("Pembimbing Pendamping: " + pembimbingP);

        // Tambahkan atribut ke model untuk konfirmasi atau notifikasi di halaman
        // berikutnya
        model.addAttribute("message", "Data TA berhasil disimpan!");
        model.addAttribute("email", email);
        model.addAttribute("role", role);

        // Redirect kembali ke halaman penguji atau halaman lainnya
        return "redirect:/penguji?email=" + email + "&role=" + role;
    }

    // Endpoint untuk kembali ke home
    @PostMapping("/home")
    public String goHome(@RequestParam("email") String email,
            @RequestParam("role") String role,
            Model model) {
        model.addAttribute("email", email);
        model.addAttribute("role", role);
        return "home"; // Nama file HTML halaman home
    }
}
