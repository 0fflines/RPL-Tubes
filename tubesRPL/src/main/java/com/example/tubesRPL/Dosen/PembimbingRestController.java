// package com.example.tubesRPL.Dosen;

// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;

// @RestController
// @RequestMapping("/api/pembimbing")
// public class PembimbingRestController {

// @Autowired
// private SkripsiRepository skripsiRepository;

// @PostMapping("/catatan")
// public ResponseEntity<String> saveCatatan(@RequestBody CatatanRequest
// request) {
// int updatedRows = skripsiRepository.updateCatatan(request.getId(),
// request.getCatatan());
// if (updatedRows > 0) {
// return ResponseEntity.ok("Catatan berhasil disimpan.");
// } else {
// return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data tidak
// ditemukan.");
// }
// }

// public static class CatatanRequest {
// private int id;
// private String catatan;

// // Getter dan Setter
// public int getId() {
// return id;
// }

// public void setId(int id) {
// this.id = id;
// }

// public String getCatatan() {
// return catatan;
// }

// public void setCatatan(String catatan) {
// this.catatan = catatan;
// }
// }
// }
