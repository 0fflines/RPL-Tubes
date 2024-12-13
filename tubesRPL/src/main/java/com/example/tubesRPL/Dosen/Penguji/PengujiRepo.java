package com.example.tubesRPL.Dosen.Penguji;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PengujiRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method untuk mapping ResultSet ke TugasAkhir
    private SkripsiData mapRowToTugasAkhir(ResultSet rs, int rowNum) throws SQLException {
        return new SkripsiData(
                rs.getInt("id"),
                rs.getString("nama_mahasiswa"),
                rs.getString("judul_skripsi"),
                rs.getString("tempat"),
                rs.getString("tanggal_sidang"),
                rs.getString("semester_akademik"));
    }

    // Method untuk mengambil semua skripsi berdasarkan semester
    public List<SkripsiData> findBySemester(String semester) {
        String sql = "SELECT id, nama_mahasiswa, judul_skripsi, tempat, tanggal_sidang, semester_akademik " +
                "FROM ta_data WHERE semester_akademik = ?";
        return jdbcTemplate.query(sql, this::mapRowToTugasAkhir, semester);
    }
}
