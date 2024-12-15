package com.example.tubesRPL.Dosen.Nilai.BobotNilai;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BobotNilaiKomponen {
    private int idKomponen;
    private String namaRole;
    private String namaKomponen;
    private int bobot;
}
