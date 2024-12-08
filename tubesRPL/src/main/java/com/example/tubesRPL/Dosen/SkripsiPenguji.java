package com.example.tubesRPL.Dosen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkripsiPenguji {
    private int id;
    private String namaMahasiswa;
    private String judulSkripsi;
    private LocalDateTime waktu;
    private String tempat;
    private Integer nilai;
    private String tahunAkademik;
}
