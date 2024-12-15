package com.example.tubesRPL.Users;

public class User {
    private String nama;
    private String email;
    private String nomorInduk;
    private String password;
    private String role;

    public User(String nama, String email, String nomorInduk, String password, String role) {
        this.nama = nama;
        this.email = email;
        this.nomorInduk = nomorInduk;
        this.password = password;
        this.role = role;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNomorInduk(){
        return nomorInduk;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
