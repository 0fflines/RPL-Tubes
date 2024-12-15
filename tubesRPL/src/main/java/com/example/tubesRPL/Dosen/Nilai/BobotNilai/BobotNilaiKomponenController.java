package com.example.tubesRPL.Dosen.Nilai.BobotNilai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bobotNilai")
public class BobotNilaiKomponenController {
    @Autowired
    private BobotNilaiKomponenRepository bobotNilaiKomponenRepository;

    @GetMapping("/load")
    public List<BobotNilaiKomponen> getBobotByRole(@RequestParam String role){
        return bobotNilaiKomponenRepository.getBobotByRole(role);
    }
}
