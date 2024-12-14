package com.example.tubesRPL.Dosen.Pembimbing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CatatanRepository{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CatatanRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveCatatan(String isiCatatan, int idTA){
        String sql = "UPDATE catatan SET isi_catatan = ? WHERE id_ta = ?";
        jdbcTemplate.update(sql, isiCatatan, idTA);
    }

    private final RowMapper<Catatan> rowMapper = (rs, rowNum) -> new Catatan(
        rs.getInt("id_catatan"),
        rs.getInt("id_tA"),
        rs.getString("isi_catatan"));

    //Jika belum ada catatan untuk TAnya akan dibuat dan direturns
    public Catatan loadCatatan(int idTA){
        String sqlFind = "SELECT * FROM catatan WHERE id_ta = ?";
        Catatan result = jdbcTemplate.queryForObject(sqlFind, rowMapper, idTA);
        if(result == null){
            String sqlSave = "INSERT INTO catatan (id_ta, isi_catatan) VALUES (?,?)";
            jdbcTemplate.update(sqlSave, idTA, "");
            return jdbcTemplate.queryForObject(sqlFind, rowMapper, idTA);
        }
        return result;
    }
}
