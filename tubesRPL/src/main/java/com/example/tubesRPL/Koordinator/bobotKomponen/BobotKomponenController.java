package com.example.tubesRPL.Koordinator.bobotKomponen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bobot-komponen")
public class BobotKomponenController {

    private final BobotKomponenJdbcRepository bobotKomponenRepository;

    @Autowired
    public BobotKomponenController(BobotKomponenJdbcRepository bobotKomponenRepository) {
        this.bobotKomponenRepository = bobotKomponenRepository;
    }

    // Endpoint untuk mendapatkan semua komponen penguji
    @GetMapping("/penguji")
    public ResponseEntity<List<BobotKomponen>> getBobotKomponenPenguji() {
        List<BobotKomponen> komponenPenguji = bobotKomponenRepository.findBobotKomponenPenguji();
        return ResponseEntity.ok(komponenPenguji);
    }

    // Endpoint untuk mendapatkan semua komponen pembimbing
    @GetMapping("/pembimbing")
    public ResponseEntity<List<BobotKomponen>> getBobotKomponenPembimbing() {
        List<BobotKomponen> komponenPembimbing = bobotKomponenRepository.findBobotKomponenPembimbing();
        return ResponseEntity.ok(komponenPembimbing);
    }

    @GetMapping("/{id}")
    public BobotKomponen getKomponenById(@PathVariable int id) {
        return bobotKomponenRepository.findById(id);
    }

    // Endpoint untuk menambahkan komponen baru
    @PostMapping("/add")
    public Map<String, String> addKomponen(@RequestParam String nama_komponen,
            @RequestParam double bobot,
            @RequestParam String nama_role) {
        BobotKomponen bobotKomponen = new BobotKomponen();
        bobotKomponen.setNama_komponen(nama_komponen);
        bobotKomponen.setBobot(bobot);
        bobotKomponen.setNama_role(nama_role);
        bobotKomponenRepository.addBobotKomponen(bobotKomponen);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Komponen berhasil ditambahkan");
        return response;
    }

    // Endpoint untuk memperbarui komponen berdasarkan id
    @PutMapping("/{id}")
    public Map<String, String> updateKomponen(@PathVariable int id_komponen,
        @RequestParam String nama_komponen,
        @RequestParam String nama_role, 
        @RequestParam double bobot) {
        BobotKomponen bobotKomponen = new BobotKomponen() ;
        bobotKomponen.setId_komponen(id_komponen);
        bobotKomponen.setNama_komponen(null);
        bobotKomponen.setNama_role(null);
        bobotKomponen.setBobot(bobot);
        bobotKomponenRepository.updateBobotKomponen(bobotKomponen);
    
        Map<String, String> response = new HashMap<>();
        response.put("message", "Komponen berhasil diperbarui");
        return response;
    }

    // Endpoint untuk menghapus komponen
    @DeleteMapping("/{id}")
    public Map<String, String> deleteKomponen(@PathVariable int id_komponen) {
        bobotKomponenRepository.deleteBobotKomponen(id_komponen);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Komponen berhasil dihapus");
        return response;
    }

}
