package com.example.tubesRPL.Koordinator.TA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
                java.sql.Timestamp.valueOf(taData.getTanggalSidang()), // Konversi LocalDateTime ke Timestamp
                taData.getPenguji1(),
                taData.getPenguji2(),
                taData.getPembimbingUtama(),
                taData.getPembimbingPendamping(),
                taData.getSemesterAkademik());
    }
    
    private final RowMapper<TAData> rowMapper = (rs, rowNum) -> new TAData(
        rs.getInt("id"),
        rs.getString("nama_mahasiswa"),
        rs.getString("judul_skripsi"),
        rs.getString("jenis_ta"),
        rs.getString("tempat"),
        rs.getTimestamp("tanggal_sidang").toLocalDateTime(), // Konversi Timestamp ke LocalDateTime
        rs.getString("penguji_1"),
        rs.getString("penguji_2"),
        rs.getString("pembimbing_utama"),
        rs.getString("pembimbing_pendamping"),
        rs.getString("semester_akademik"));

    @Override
    public List<TAData> findAll() {
        String sql = "SELECT * FROM ta_data";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<TAData> findBySemesterAkademikPenguji(String semesterAkademik, String namaDosen) {
        String sql = "SELECT * FROM ta_data WHERE semester_akademik = ? "+
        "AND (penguji_1 = ? OR penguji_2 = ?)";
        return jdbcTemplate.query(sql, rowMapper, semesterAkademik, namaDosen, namaDosen);
    }

    @Override
    public List<TAData> findBySemesterAkademikPembimbing(String semesterAkademik, String namaDosen) {
        String sql = "SELECT * FROM ta_data WHERE semester_akademik = ? "+
        "AND (pembimbing_utama = ? OR pembimbing_pendamping = ?)";
        return jdbcTemplate.query(sql, rowMapper, semesterAkademik, namaDosen, namaDosen);
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
                java.sql.Timestamp.valueOf(taData.getTanggalSidang()), // Konversi LocalDateTime ke Timestamp
                taData.getPenguji1(),
                taData.getPenguji2(),
                taData.getPembimbingUtama(),
                taData.getPembimbingPendamping(),
                taData.getSemesterAkademik(),
                taData.getId());
    }
    
    @Override
    public List<TAData> findBysemesterAkademik(String semesterAkademik) {
        String sql = "SELECT * FROM ta_data WHERE semester_akademik = ?";
        return jdbcTemplate.query(sql, rowMapper, semesterAkademik);
    }

    @Override
    public List<String> findAllSemesterAkademik() {
        String sql = "SELECT DISTINCT semester_akademik FROM ta_data ORDER BY semester_akademik DESC";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    @Override
    public List<String> findAllSemesterAkademikPembimbing(String namaDosen) {
        String sql = "SELECT DISTINCT semester_akademik FROM ta_data "+
        "WHERE pembimbing_utama = ? OR pembimbing_pendamping = ? ORDER BY semester_akademik DESC";
        return jdbcTemplate.queryForList(sql, String.class, namaDosen, namaDosen);
    }

    @Override
    public List<String> findAllSemesterAkademikPenguji(String namaDosen) {
        String sql = "SELECT DISTINCT semester_akademik FROM ta_data "+
        "WHERE penguji_1 = ? OR penguji_2 = ? ORDER BY semester_akademik DESC";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
