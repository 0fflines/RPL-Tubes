package com.example.tubesRPL.Koordinator.TA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TADataJdbcRepository implements TAInterface {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TADataJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(TAData taData) {
        String sql = "INSERT INTO ta_data (nama_mahasiswa, judul_skripsi, jenis_ta, tempat, tanggal_sidang, " +
                "penguji_1, penguji_2, pembimbing_utama, pembimbing_pendamping, semester_akademik) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                taData.getNamaMahasiswa(),
                taData.getJudulSkripsi(),
                taData.getJenisTa(),
                taData.getTempat(),
                taData.getTanggalSidang(),
                taData.getPenguji1(),
                taData.getPenguji2(),
                taData.getPembimbingUtama(),
                taData.getPembimbingPendamping(),
                taData.getSemesterAkademik());
    }

    @Override
    public List<TAData> findAll() {
        String sql = "SELECT * FROM ta_data";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new TAData(
                rs.getInt("id"),
                rs.getString("nama_mahasiswa"),
                rs.getString("judul_skripsi"),
                rs.getString("jenis_ta"),
                rs.getString("tempat"),
                rs.getString("tanggal_sidang"),
                rs.getString("penguji_1"),
                rs.getString("penguji_2"),
                rs.getString("pembimbing_utama"),
                rs.getString("pembimbing_pendamping"),
                rs.getString("semester_akademik")));
    }

    @Override
    public boolean existsById(Integer id) {
        String sql = "SELECT COUNT(*) FROM ta_data WHERE id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "DELETE FROM ta_data WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int update(TAData taData) {
        String sql = "UPDATE ta_data SET nama_mahasiswa = ?, judul_skripsi = ?, jenis_ta = ?, tempat = ?, " +
                "tanggal_sidang = ?, penguji_1 = ?, penguji_2 = ?, pembimbing_utama = ?, pembimbing_pendamping = ?, " +
                "semester_akademik = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                taData.getNamaMahasiswa(),
                taData.getJudulSkripsi(),
                taData.getJenisTa(),
                taData.getTempat(),
                taData.getTanggalSidang(),
                taData.getPenguji1(),
                taData.getPenguji2(),
                taData.getPembimbingUtama(),
                taData.getPembimbingPendamping(),
                taData.getSemesterAkademik(),
                taData.getId());
    }
}
