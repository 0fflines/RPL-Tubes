package com.example.tubesRPL.BAP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BAPDataRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BAPDataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BAPData> findAll() {
        String query = "SELECT * FROM ta_data";
        return jdbcTemplate.query(query, rowMapper());
    }

    private RowMapper<BAPData> rowMapper() {
        return (rs, rowNum) -> {
            BAPData taData = new BAPData();
            taData.setIdTa(rs.getLong("id_ta"));
            taData.setNamaMahasiswa(rs.getString("nama_mahasiswa"));
            taData.setJudulSkripsi(rs.getString("judul_skripsi"));
            taData.setJenisTa(rs.getString("jenis_ta"));
            taData.setRuangan(rs.getString("ruangan"));
            taData.setTanggalSidang(rs.getTimestamp("tanggal_sidang"));
            taData.setPenguji1(rs.getString("penguji_1"));
            taData.setPenguji2(rs.getString("penguji_2"));
            taData.setPembimbing(rs.getString("pembimbing"));
            taData.setSemesterAkademik(rs.getString("semester_akademik"));
            return taData;
        };
    }
}