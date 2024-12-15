package com.example.tubesRPL.Dosen.Nilai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.tubesRPL.Dosen.Nilai.BobotNilai.BobotNilaiKomponenRepository;

@Repository
public class NilaiKomponenTARepository {
    @Autowired
    BobotNilaiKomponenRepository bobotNilaiKomponenRepository;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public NilaiKomponenTARepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<NilaiKomponenTA> rowMapper = (rs, rowNum) -> new NilaiKomponenTA(
        rs.getInt("id_nilaikomponenta"),
        rs.getString("nama_komponen"),
        rs.getString("role_penilai"),
        rs.getInt("nilai"),
        rs.getInt("id_ta"));

    public void saveNilai(List<Integer> listNilai, List<Integer> listIdNilaiKomponenTA){
        String sql = "UPDATE nilai_komponenta SET nilai = ? WHERE id_nilaikomponenta = ?";
        for(int i = 0; i < listNilai.size(); i++){
            int nilai = listNilai.get(i);
            int idNilaiKomponenTA = listIdNilaiKomponenTA.get(i);
            //jika waktu update tidak ketemu/belum di inisialisasi
            jdbcTemplate.update(sql, nilai, idNilaiKomponenTA);
        }
    }

    public List<NilaiKomponenTA> loadNilai(String role, int idTA){
        String sql = "SELECT * FROM nilai_komponenta WHERE (role_penilai = ? AND id_ta = ?)";
        List<NilaiKomponenTA> listResult = jdbcTemplate.query(sql, rowMapper, role, idTA);
        //kalau 0 berarti belum di inisialisasi
        if(listResult.size() == 0){
            List<String> listKomponen = bobotNilaiKomponenRepository.getKomponenByRole(role);
            String sqlInsert = "INSERT INTO nilai_komponenta (nama_komponen, role_penilai, nilai, id_ta) VALUES (?,?,?,?)";
            for(int i = 0; i < listKomponen.size(); i++){
                jdbcTemplate.update(sqlInsert, listKomponen.get(i), role, null, idTA);
            }
            //ambil ulang
            listResult = jdbcTemplate.query(sql, rowMapper);
        }
        return listResult;
    }
}
