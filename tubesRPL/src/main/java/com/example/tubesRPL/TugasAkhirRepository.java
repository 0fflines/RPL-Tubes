package com.example.tubesRPL;

import org.springframework.stereotype.Repository;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class TugasAkhirRepository {
    private JdbcTemplate jdbcTemplate;

    public void TugasAkhir(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateBapFile(int id, byte[] bapFile) {
        String sql = "UPDATE tugas_akhir SET bap_file = ? WHERE id = ?";

        try {
            jdbcTemplate.update(sql, bapFile, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public byte[] getBapFile(int id) {
        String sql = "SELECT bap_file FROM tugas_akhir WHERE id = ?";
        RowMapper<byte[]> rowMapper = (rs, rowNum) -> rs.getBytes("bap_file");
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}