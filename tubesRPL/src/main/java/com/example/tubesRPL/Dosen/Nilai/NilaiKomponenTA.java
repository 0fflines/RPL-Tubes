package com.example.tubesRPL.Dosen.Nilai;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NilaiKomponenTA {
    private int idNilaiKomponenTA;
    private String namaKomponen;
    private String rolePenilai;
    private int nilai;
    private int idTA;
    private String namaDosen;
}
