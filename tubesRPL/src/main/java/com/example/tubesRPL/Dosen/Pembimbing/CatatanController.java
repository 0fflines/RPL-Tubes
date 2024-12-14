package com.example.tubesRPL.Dosen.Pembimbing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catatan")
public class CatatanController {
    @Autowired
    private CatatanRepository catatanRepository;

    @GetMapping("/load")
    public Catatan loadCatatan(@RequestParam int idTA){
        Catatan catatan = catatanRepository.loadCatatan(idTA);
        System.out.println(catatan);
        return catatanRepository.loadCatatan(idTA);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCatatan(@RequestParam("isiCatatan") String isiCatatan,  @RequestParam("idTA") int idTA){
        catatanRepository.saveCatatan(isiCatatan, idTA);
        return ResponseEntity.ok("Saved");
    }
}
