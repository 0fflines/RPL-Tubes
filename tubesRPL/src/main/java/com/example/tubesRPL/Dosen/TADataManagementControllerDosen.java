package com.example.tubesRPL.Dosen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.tubesRPL.Koordinator.TA.TAData;
import com.example.tubesRPL.Koordinator.TA.TAInterface;

import java.util.List;

@RestController
@RequestMapping("/api/dosen/ta")
public class TADataManagementControllerDosen {

    private final TAInterface taInterface;

    @Autowired
    public TADataManagementControllerDosen(TAInterface taInterface) {
        this.taInterface = taInterface;
    }

    // Endpoint to fetch all TA data
    @GetMapping("/all")
    public List<TAData> getAllTAData() {
        return taInterface.findAll(); // Fetch and return all TA data
    }

    @GetMapping("/pembimbing/daftar")
    public List<TAData> getTAdataBySemesterAkademikPembimbing(
            @RequestParam(value = "semesterAkademik", required = false) String semesterAkademik,
            @RequestParam(value = "namaDosen") String namaDosen) {
        if (semesterAkademik == null || semesterAkademik.isEmpty()) {
            semesterAkademik = "Ganjil 2024/2025"; // Default value
        }
        return  taInterface.findBySemesterAkademikPembimbing(semesterAkademik, namaDosen);
    }

    @GetMapping("/penguji/daftar")
    public List<TAData> getTAdataBySemesterAkademikPenguji(
        @RequestParam(value = "semesterAkademik", required = false) String semesterAkademik,
        @RequestParam(value = "namaDosen") String namaDosen) {
        if (semesterAkademik == null || semesterAkademik.isEmpty()) {
            semesterAkademik = "Ganjil 2024/2025"; // Default value
        }
        return  taInterface.findBySemesterAkademikPenguji(semesterAkademik, semesterAkademik);
    }

    // Endpoint to fetch a single TA data by ID
    @GetMapping("/{id}")
    public TAData getTADataById(@PathVariable Integer id) {
        return taInterface.existsById(id) ? taInterface.findAll().stream()
                .filter(taData -> taData.getId().equals(id))
                .findFirst()
                .orElse(null) : null; // Return the TA data if exists
    }

    @GetMapping("/pembimbing/daftar/semesters")
    public List<String> getAvailableSemestersPembimbing(@RequestParam(value = "namaDosen") String namaDosen) {
        return taInterface.findAllSemesterAkademikPembimbing(namaDosen);
    }

    @GetMapping("/penguji/daftar/semesters")
    public List<String> getAvailableSemestersPenguji(@RequestParam(value = "namaDosen") String namaDosen) {
        return taInterface.findAllSemesterAkademikPenguji(namaDosen);
    }
}
