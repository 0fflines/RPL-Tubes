package com.example.tubesRPL.Koordinator.bobotKomponen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BobotKomponenJdbcRepository {
     private final JdbcTemplate jdbcTemplate;

     @Autowired
     public BobotKomponenJdbcRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
     }

    public List<BobotKomponen> findBobotKomponenPenguji(){
        String sql = "SELECT * FROM bobot_nilaiKomponen WHERE nama_role LIKE 'penguji' ";
        return jdbcTemplate.query(sql, this::mapRowToBobotKomponen);
    }

    public List<BobotKomponen> findBobotKomponenPembimbing(){
        String sql = "SELECT * FROM bobot_nilaiKomponen WHERE nama_role LIKE 'pembimbing'";
        return jdbcTemplate.query(sql, this::mapRowToBobotKomponen);
    }

    // Menambahkan komponen baru
    public void addBobotKomponen(BobotKomponen bobotKomponen) {
        String sql = "INSERT INTO bobot_nilaiKomponen (nama_role, nama_komponen, bobot) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, bobotKomponen.getNama_role(), bobotKomponen.getNama_komponen(), bobotKomponen.getBobot());
    }

    public void updateBobotKomponen(BobotKomponen bobotKomponen){
        String sql = "UPDATE bobot_nilaiKomponen SET bobot = ? WHERE id_komponen = ?";
        jdbcTemplate.update(sql, bobotKomponen.getBobot(), bobotKomponen.getId_komponen());
    }

    public void deleteBobotKomponen(int id_komponen){
        String sql = "DELETE FROM bobot_nilaiKomponen WHERE id_komponen = ?";
        jdbcTemplate.update(sql, id_komponen);
    }
     // Mapping ResultSet ke bobotKomponen
    private BobotKomponen mapRowToBobotKomponen(ResultSet resultSet, int rowNum) throws SQLException {
        return new BobotKomponen(
                resultSet.getInt("id_komponen"),
                resultSet.getString("nama_role"),
                resultSet.getString("nama_komponen"),
                resultSet.getDouble("bobot"));
    }

    // Mendapatkan data mesin berdasarkan ID
    public BobotKomponen findById(int id) {
        String sql = "SELECT * WHERE id_komponen = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRowToBobotKomponen, id);
    }
}