package com.example.tubesRPL.Users;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BatchInsertUser {
    public static void main(String[] args) {
        // Membuat daftar pengguna
        List<User> users = new ArrayList<>();
        // Data Dosen
        users.add(
                new User("Keenan Adiwijaya Leman, S.T, M.T", "keenan.leman@unpar.ac.id", "D001", "dosen123", "dosen"));
        users.add(new User("Maria Veronica, S.T, M.T", "maria.veronica@unpar.ac.id", "D002", "dosen123", "dosen"));
        users.add(new User("Lionov, Ph.D", "lionov@unpar.ac.id", "D003", "dosen123", "dosen"));
        users.add(new User("Raymond Chandra Putra, S.T., M.T", "raymond.chandra@unpar.ac.id", "D004", "dosen123",
                "dosen"));
        users.add(new User("Husnul Hakim, S.Kom., M.T", "husnulhakim@unpar.ac.id", "D005", "dosen123", "dosen"));
        users.add(
                new User("Pascal Alfadian Nugroho, S.Kom., M.Comp", "pascal@unpar.ac.id", "D006", "dosen123", "dosen"));
        users.add(new User("Natalia, S.Si., M.Si", "natalia@unpar.ac.id", "D007", "dosen123", "dosen"));
        users.add(new User("Vania Natali, S.Kom., M.T", "vania.natali@unpar.ac.id", "D008", "dosen123", "dosen"));
        users.add(new User("Luciana Abednego, S.Kom., M.T", "luciana@unpar.ac.id", "D009", "dosen123", "dosen"));

        // Data Mahasiswa
        users.add(
                new User("Faisal Surya Setya Pratama", "6181901073@student.unpar.ac.id", "6186181901073",
                        "mahasiswa123", "mahasiswa"));
        users.add(new User("Richard Sastraputra", "6182201001@student.unpar.ac.id", "6182201001", "mahasiswa123",
                "mahasiswa"));
        users.add(
                new User("Alvin Chandra", "6182201005@student.unpar.ac.id", "6182201005", "mahasiswa123", "mahasiswa"));
        users.add(new User("Zefandion Benaya Teja", "6182201042@student.unpar.ac.id", "6182201042", "mahasiswa123",
                "mahasiswa"));
        users.add(new User("Kevin Halim", "6182201102@student.unpar.ac.id", "6182201042", "mahasiswa123", "mahasiswa"));

        // Data Koordinator
        users.add(
                new User("Mariskha Tri Adithia, S.Si., M.Sc., PDEng", "mariskha@unpar.ac.id", "D010", "koordinator123",
                        "koordinator"));

        // Memasukkan data pengguna ke database
        insertUsers(users);

        // Mengisi tabel mahasiswa secara otomatis
        insertMahasiswa();
    }

    public static void insertUsers(List<User> users) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Informasi koneksi database
        String jdbcUrl = "jdbc:postgresql://localhost:5432/rpl";
        String dbUser = "postgres";
        String dbPassword = "7november2003";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String sql = "INSERT INTO users (nama_users, email_users, password, role) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Tambahkan setiap data pengguna ke batch
                for (User user : users) {
                    preparedStatement.setString(1, user.getNama());
                    preparedStatement.setString(2, user.getEmail());
                    preparedStatement.setString(3, passwordEncoder.encode(user.getPassword()));
                    preparedStatement.setString(4, user.getRole());
                    preparedStatement.addBatch();
                }

                // Eksekusi batch insert
                int[] rowsInserted = preparedStatement.executeBatch();
                System.out.println(rowsInserted.length + " users berhasil ditambahkan dengan password terenkripsi!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertMahasiswa() {
        // Informasi koneksi database
        String jdbcUrl = "jdbc:postgresql://localhost:5432/rpl";
        String dbUser = "postgres";
        String dbPassword = "7november2003";

        String sql = "INSERT INTO mahasiswa (nama_mahasiswa, npm, email_mahasiswa, password_mahasiswa) " +
                "SELECT u.nama_users, " +
                "       u.nomor_induk AS npm, " + // Mengambil nomor_induk sebagai NPM
                "       u.email_users, " +
                "       u.password " +
                "FROM users u " +
                "WHERE u.role = 'mahasiswa'";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            try (Statement statement = connection.createStatement()) {
                int rowsInserted = statement.executeUpdate(sql);
                System.out.println(rowsInserted + " mahasiswa berhasil ditambahkan!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
