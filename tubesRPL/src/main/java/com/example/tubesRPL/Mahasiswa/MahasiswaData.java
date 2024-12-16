package com.example.tubesRPL.Mahasiswa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MahasiswaData {
    private String judulSkripsi;
    private String jenisTA;
    private String waktu;
    private String penguji1;
    private String penguji2;
    private String pembimbingUtama;
}