package com.example.tubesRPL.Dosen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/api/penguji")
public class PengujiRestController {

    @Autowired
    private SkripsiRepository skripsiRepository;

    @GetMapping("/skripsi")
    public List<SkripsiPenguji> getSkripsiByTahunAkademik(
            @RequestParam(value = "tahunAkademik", required = false) String tahunAkademik) {
        if (tahunAkademik == null || tahunAkademik.isEmpty()) {
            tahunAkademik = "Ganjil 2024/2025"; // Default value
        }
        return skripsiRepository.findByTahunAkademik(tahunAkademik);
    }

    @GetMapping("/penguji")
    public String getPembimbingPage(
            @RequestParam(value = "tahunAkademik", defaultValue = "2023/2024") String tahunAkademik, Model model) {
        List<SkripsiPenguji> skripsiList = skripsiRepository.findByTahunAkademik(tahunAkademik);
        model.addAttribute("skripsiList", skripsiList);
        model.addAttribute("tahunAkademik", tahunAkademik);
        return "dosen/pembimbing";
    }

    @GetMapping("/skripsi/semesters")
    public List<String> getAvailableSemesters() {
        return skripsiRepository.findAllTahunAkademik();
    }
}
