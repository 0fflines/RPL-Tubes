package com.example.tubesRPL.Dosen.Penguji;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkripsiData {
    private int id;
    private String namaMahasiswa;
    private String judulSkripsi;
    private String tempat;
    private String tanggalSidang;
    private String semesterAkademik;
}