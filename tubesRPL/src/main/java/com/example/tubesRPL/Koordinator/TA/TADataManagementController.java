package com.example.tubesRPL.Koordinator.TA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/koordinator/ta")
public class TADataManagementController {

    private final TAInterface taInterface;

    @Autowired
    public TADataManagementController(TAInterface taInterface) {
        this.taInterface = taInterface;
    }

    // Endpoint to fetch all TA data
    @GetMapping("/all")
    public List<TAData> getAllTAData() {
        return taInterface.findAll(); // Fetch and return all TA data
    }

    // Endpoint to fetch a single TA data by ID
    @GetMapping("/{id}")
    public TAData getTADataById(@PathVariable Integer id) {
        return taInterface.existsById(id) ? taInterface.findAll().stream()
                .filter(taData -> taData.getId().equals(id))
                .findFirst()
                .orElse(null) : null; // Return the TA data if exists
    }

    // Endpoint to save new TA data
    // Endpoint untuk menyimpan data TA baru
    @PostMapping("/save")
    public String saveTAData(@ModelAttribute TAData taData, Model model) {
        try {
            taData.setTanggalSidang(LocalDateTime.parse(taData.getTanggalSidang().toString())); // Parsing string ke LocalDateTime
            int result = taInterface.save(taData);
            taInterface.saveNilaiDisiplin(taData);
            model.addAttribute("message", result > 0 ? "TA data berhasil disimpan!" : "Gagal menyimpan data TA!");
        } catch (Exception e) {
            model.addAttribute("message", "Error: " + e.getMessage());
        }
        return "TA berhasil dibuat";
    }

    @GetMapping("/daftar")
    public List<TAData> getTAdataBySemesterAkademik(
            @RequestParam(value = "semesterAkademik", required = false) String semesterAkademik) {
        if (semesterAkademik == null || semesterAkademik.isEmpty()) {
            semesterAkademik = "Ganjil 2024/2025"; // Default value
        }
        return  taInterface.findBysemesterAkademik(semesterAkademik);
    }


    // Endpoint to update an existing TA data entry
    @PutMapping("/update/{id}")
    public String updateTAData(@PathVariable Integer id, @RequestBody TAData taData) {
        if (taInterface.existsById(id)) {
            taData.setId(id); // Ensure the existing ID is updated
            int result = taInterface.update(taData);
            return result > 0 ? "TA data berhasil diupdate!" : "Gagal mengupdate TA data!";
        } else {
            return "TA data tidak ditemukan!";
        }
    }

    // Endpoint to delete a TA data entry by ID
    @DeleteMapping("/delete/{id}")
    public String deleteTAData(@PathVariable Integer id) {
        if (taInterface.existsById(id)) {
            int result = taInterface.deleteById(id);
            return result > 0 ? "TA data berhasil dihapus!" : "Gagal menghapus TA data!";
        } else {
            return "TA data tidak ditemukan!";
        }
    }

    @GetMapping("/daftar/semesters")
    public List<String> getAvailableSemesters() {
        return taInterface.findAllSemesterAkademik();
    }

}