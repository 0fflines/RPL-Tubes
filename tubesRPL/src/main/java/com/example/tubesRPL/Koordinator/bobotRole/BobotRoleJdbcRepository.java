package com.example.tubesRPL.Koordinator.bobotRole;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class BobotRoleJdbcRepository implements BobotRoleInterface {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BobotRoleJdbcRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> findBobotPenguji() {
        String sql = "SELECT DISTINCT bobotPenguji FROM bobotRoleORDER BY bobotPenguji ASC";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    @Override
    public List<String> findBobotPembimbing() {
        String sql = "SELECT DISTINCT bobotPembimbing FROM bobotRoleORDER BY bobotPembimbingASC";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    @Override
    public List<String> findBobotKoordinator() {
        String sql = "SELECT DISTINCT bobotKoordinator FROM bobotRole ORDER BY bobotKoordinator ASC";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
