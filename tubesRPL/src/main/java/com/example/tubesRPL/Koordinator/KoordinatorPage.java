package com.example.tubesRPL.Koordinator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.tubesRPL.Koordinator.TA.TADataJdbcRepository;

@Controller
public class KoordinatorPage {
    @Autowired
    private TADataJdbcRepository taDataJdbcRepository;

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
    public String homeCreate(Model model) {
        // Mengambil data dari database untuk dropdown
        List<String> listNamaMahasiswa = taDataJdbcRepository.findAllMahasiswa();
        List<String> listDosen = taDataJdbcRepository.findAllDosen();
        List<String> listRuangan = taDataJdbcRepository.findAllTempat();

        // Menambahkan data ke model agar bisa diakses di template HTML
        model.addAttribute("listNamaMahasiswa", listNamaMahasiswa);
        model.addAttribute("listDosen", listDosen);
        model.addAttribute("listRuangan", listRuangan);

        return "koor/create";
    }
    
}
