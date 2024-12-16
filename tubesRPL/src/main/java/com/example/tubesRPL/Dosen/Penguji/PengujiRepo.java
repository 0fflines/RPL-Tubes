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
                rs.getInt("id_ta"),
                rs.getString("nama_mahasiswa"),
                rs.getString("judul_skripsi"),
                rs.getString("ruangan"),
                rs.getString("tanggal_sidang"),
                rs.getString("semester_akademik"));
    }

    // Method untuk mengambil semua skripsi berdasarkan semester
    public List<SkripsiData> findBySemester(String semester) {
        String sql = "SELECT id_ta, nama_mahasiswa, judul_skripsi, ruangan, tanggal_sidang, semester_akademik " +
                "FROM ta_data WHERE semester_akademik = ?";
        return jdbcTemplate.query(sql, this::mapRowToTugasAkhir, semester);
    }

    public List<SkripsiData> findByPenguji(String penguji) {
        String sql = "SELECT id_ta, nama_mahasiswa, judul_skripsi, ruangan, tanggal_sidang, semester_akademik "
                + "FROM ta_data WHERE penguji_1 = ? OR penguji_2 = ?";
        System.out.println("Executing query: " + sql + " with params: " + penguji);
        return jdbcTemplate.query(sql, this::mapRowToTugasAkhir, penguji, penguji);
    }

    public List<SkripsiData> findByPembimbing(String pembimbing) {
        String sql = "SELECT id_ta, nama_mahasiswa, judul_skripsi, ruangan, tanggal_sidang, semester_akademik " +
                "FROM ta_data WHERE pembimbing = ?";
        System.out.println("Executing query: " + sql + " with params: " + pembimbing);
        return jdbcTemplate.query(sql, this::mapRowToTugasAkhir, pembimbing);
    }
}