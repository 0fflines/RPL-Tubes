package com.example.tubesRPL.User;

import lombok.Data;

@Data
public class User {
    private int id; // ID unik untuk setiap user
    private String name; // Nama lengkap pengguna
    private String email; // Email unik pengguna
    private String password; // Password (terenkripsi)
    private String role; // Role pengguna (default: mahasiswa)

    // Constructor default dengan nilai default untuk role
    public User() {
        this.role = "mahasiswa"; // Default role adalah mahasiswa
    }
}
