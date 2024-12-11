package com.example.tubesRPL.Register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String namaLengkap;
    private String npm;
    private String email;
    private String password;
    private String role;
}