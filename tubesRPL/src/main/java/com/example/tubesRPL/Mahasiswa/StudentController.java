package com.example.tubesRPL.Mahasiswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/dataSidang") // Prefix untuk semua endpoint dalam controller ini
public class StudentController {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    // Endpoint untuk mendapatkan semua data skripsi
    @GetMapping
    public List<MahasiswaData> getAllSkripsi() {
        return mahasiswaRepository.findAll();
    }
}
