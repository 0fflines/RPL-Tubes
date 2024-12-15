package com.example.tubesRPL;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TugasAkhir {
    private int id;
    private String namaMahasiswa;
    private String judulSkripsi;
    private LocalDateTime waktuSidang;
    private String tempatSidang;
    private int tipeSidang;
    private byte[] fileBap;
}
