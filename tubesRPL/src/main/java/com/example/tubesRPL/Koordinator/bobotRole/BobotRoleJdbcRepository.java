package com.example.tubesRPL.Koordinator.bobotRole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class BobotRoleJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BobotRoleJdbcRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BobotRole> findBobotRole() {
        String sql = "SELECT * FROM bobotRole";
        return jdbcTemplate.query(sql, this::mapRowToBobotRole);
    }

    public void updateBobotRole(BobotRole bobotRole) {
        String sql = "UPDATE bobotRole SET bobotPenguji = ?, bobotPembimbing = ?, bobotKoordinator = ? WHERE id_bobotRole = ?";
        jdbcTemplate.update(sql, bobotRole.getBobotPenguji(), bobotRole.getBobotPembimbing(), bobotRole.getBobotKoordinator(), bobotRole.getId_bobotRole());
    }
    

    private BobotRole mapRowToBobotRole(ResultSet resultSet, int rowNum) throws SQLException {
        return new BobotRole(
                resultSet.getInt("id_bobotRole"),
                resultSet.getDouble("bobotPenguji"),
                resultSet.getDouble("bobotPembimbing"),
                resultSet.getDouble("bobotkoordinator"));
    }
}
