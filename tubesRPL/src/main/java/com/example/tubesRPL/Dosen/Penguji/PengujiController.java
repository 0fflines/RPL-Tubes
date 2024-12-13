package com.example.tubesRPL.Dosen.Penguji;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skripsi")
@CrossOrigin(origins = "*") // Agar dapat diakses oleh frontend
public class PengujiController {

    @Autowired
    private PengujiRepo repository;

    // Endpoint untuk mendapatkan data berdasarkan semester
    @GetMapping
    public List<SkripsiData> getSkripsiBySemester(@RequestParam String semester) {
        return repository.findBySemester(semester);
    }
}
