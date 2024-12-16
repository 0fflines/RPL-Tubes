package com.example.tubesRPL.BAP;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BAPData {
    private Long idTa;
    private String namaMahasiswa;
    private String judulSkripsi;
    private String jenisTa;
    private String ruangan;
    private Timestamp tanggalSidang;
    private String penguji1;
    private String penguji2;
    private String pembimbing;
    private String semesterAkademik;
}