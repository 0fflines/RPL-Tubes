package com.example.tubesRPL.Mahasiswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MahasiswaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method untuk mapping hasil ResultSet ke objek MahasiswaData
    // private MahasiswaData mapRowToTugasAkhir(ResultSet rs, int rowNum) throws SQLException {
    //     return new MahasiswaData(
    //             rs.getString("judul_skripsi"),
    //             rs.getString("jenis_ta"),
    //             rs.getString("tanggal_sidang"),
    //             rs.getString("penguji_1"),
    //             rs.getString("penguji_2"),
    //             rs.getString("pembimbing"));
    // }

    private final RowMapper<MahasiswaData> rowMapper = (rs, rowNum) -> new MahasiswaData(
        rs.getInt("id_ta"),
        rs.getString("judul_skripsi"),
        rs.getString("jenis_ta"),
        rs.getString("tanggal_sidang"),
        rs.getString("penguji_1"),
        rs.getString("penguji_2"),
        rs.getString("pembimbing"));


    // Method untuk mengambil semua data dari tabel
    public List<MahasiswaData> findAll(String namaMahasiswa) {
        String sql = "SELECT id_ta, judul_skripsi, jenis_ta, tanggal_sidang, penguji_1, penguji_2, pembimbing FROM ta_data WHERE nama_mahasiswa=?";
        return jdbcTemplate.query(sql, rowMapper, namaMahasiswa);
    }
}
