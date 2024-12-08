package com.example.tubesRPL.Dosen;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkripsiRepository {

    private final JdbcTemplate jdbcTemplate;

    public SkripsiRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<SkripsiPenguji> rowMapper = (rs, rowNum) -> new SkripsiPenguji(
            rs.getInt("id"),
            rs.getString("nama_mahasiswa"),
            rs.getString("judul_skripsi"),
            rs.getTimestamp("waktu").toLocalDateTime(),
            rs.getString("tempat"),
            rs.getObject("nilai", Integer.class),
            rs.getString("tahun_akademik"));

    public List<SkripsiPenguji> findAll() {
        String sql = "SELECT * FROM skripsi_penguji";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<SkripsiPenguji> findByTahunAkademik(String tahunAkademik) {
        String sql = "SELECT * FROM skripsi_penguji WHERE tahun_akademik = ?";
        return jdbcTemplate.query(sql, rowMapper, tahunAkademik);
    }

    public int save(SkripsiPenguji penguji) {
        String sql = "INSERT INTO skripsi_penguji (nama_mahasiswa, judul_skripsi, waktu, tempat, nilai, tahun_akademik) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, penguji.getNamaMahasiswa(), penguji.getJudulSkripsi(), penguji.getWaktu(),
                penguji.getTempat(), penguji.getNilai(), penguji.getTahunAkademik());
    }

    public List<String> findAllTahunAkademik() {
        String sql = "SELECT DISTINCT tahun_akademik FROM skripsi_penguji ORDER BY tahun_akademik DESC";
        return jdbcTemplate.queryForList(sql, String.class);
    }
    
}
