package com.example.tubesRPL.Dosen.Nilai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nilai")
public class NilaiKomponenTAController {
    @Autowired
    private NilaiKomponenTARepository nilaiKomponenTARepository;

    @GetMapping("/load")
    private List<NilaiKomponenTA> loadNilai(@RequestParam("namaRole") String role, @RequestParam("idTA") int idTA, @RequestParam("namaDosen") String namaDosen) {
        return nilaiKomponenTARepository.loadNilai(role, idTA, namaDosen);
    }

    @PostMapping("/save")
    private void saveNilai(@RequestParam("nilai") List<Integer> listNilai,
            @RequestParam("idNilai") List<Integer> listIdNilaiKomponenTA) {
        nilaiKomponenTARepository.saveNilai(listNilai, listIdNilaiKomponenTA);
    }
}
