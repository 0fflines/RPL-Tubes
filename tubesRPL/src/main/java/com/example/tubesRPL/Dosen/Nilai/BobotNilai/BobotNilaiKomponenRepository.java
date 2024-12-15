package com.example.tubesRPL.Dosen.Nilai.BobotNilai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BobotNilaiKomponenRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BobotNilaiKomponenRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    private final RowMapper<BobotNilaiKomponen> rowMapper = (rs, rowNum) -> new BobotNilaiKomponen(
        rs.getInt("id_komponen"),
        rs.getString("nama_role"),
        rs.getString("nama_komponen"),
        rs.getInt("bobot"));
    
    public List<BobotNilaiKomponen> getBobotByRole(String role){
        String sql = "SELECT * FROM bobot_nilaikomponen WHERE nama_role = ?";
        return jdbcTemplate.query(sql, rowMapper, role);
    }

    public List<String> getKomponenByRole(String role){
        String sql = "SELECT nama_komponen FROM bobot_nilaikomponen WHERE nama_role = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("nama_komponen"), role);
    }
}
