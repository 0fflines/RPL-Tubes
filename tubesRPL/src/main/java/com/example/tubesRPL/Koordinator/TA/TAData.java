package com.example.tubesRPL.Koordinator.TA;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TAData {
    private Integer id;
    private String namaMahasiswa;
    private String judulSkripsi;
    private String jenisTa;
    private String tempat;
    private LocalDateTime tanggalSidang; 
    private String penguji1;
    private String penguji2;
    private String pembimbingUtama;
    private String pembimbingPendamping;
    private String semesterAkademik;
}