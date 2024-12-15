package com.example.tubesRPL.Users;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class UserRepository {
    private final String jdbcUrl = "jdbc:postgresql://localhost:5432/rpl";
    private final String dbUser = "postgres";
    private final String dbPassword = "7november2003";

    public User findByEmail(String email) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String sql = "SELECT * FROM users WHERE email_users = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new User(
                                resultSet.getString("nama_users"),
                                resultSet.getString("email_users"),
                                resultSet.getString("nomor_induk"),
                                resultSet.getString("password"),
                                resultSet.getString("role"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null jika pengguna tidak ditemukan
    }
}
