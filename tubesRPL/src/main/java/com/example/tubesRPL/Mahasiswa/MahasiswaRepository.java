package com.example.tubesRPL.Mahasiswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MahasiswaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method untuk mapping hasil ResultSet ke objek MahasiswaData
    private MahasiswaData mapRowToTugasAkhir(ResultSet rs, int rowNum) throws SQLException {
        return new MahasiswaData(
                rs.getString("judul_skripsi"),
                rs.getString("jenis_ta"),
                rs.getString("waktu"),
                rs.getString("penguji_1"),
                rs.getString("penguji_2"),
                rs.getString("pembimbingUtama"));
    }

    // Method untuk mengambil semua data dari tabel
    public List<MahasiswaData> findAll() {
        String sql = "SELECT judul_skripsi, jenis_ta, tanggal_sidang AS waktu, penguji_1, penguji_2, pembimbing AS pembimbingUtama, nilai FROM ta_data";
        return jdbcTemplate.query(sql, this::mapRowToTugasAkhir);
    }
}
