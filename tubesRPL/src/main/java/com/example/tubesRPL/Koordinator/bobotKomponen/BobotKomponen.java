package com.example.tubesRPL.Koordinator.bobotKomponen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BobotKomponen {
    private int id_komponen;
    private String nama_role;
    private String nama_komponen;
    private double bobot;
}
