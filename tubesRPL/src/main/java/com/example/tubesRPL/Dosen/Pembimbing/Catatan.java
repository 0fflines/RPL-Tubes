package com.example.tubesRPL.Dosen.Pembimbing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Catatan {
    private int idCatatan;
    private int idTA;
    private String isiCatatan;
}