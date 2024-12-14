package com.example.tubesRPL.Users;

public class UserInfo {
    private String nama;
    private String email;
    private String role;

    public UserInfo(String nama, String email, String role) {
        this.nama = nama;
        this.email = email;
        this.role = role;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}