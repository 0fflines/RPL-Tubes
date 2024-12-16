package com.example.tubesRPL.Koordinator.bobotRole;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/bobot-role")
public class BobotRoleController {
    
    @Autowired
    private BobotRoleJdbcRepository bobotRoleJdbcRepository;

    @GetMapping("/bobotAll")
    public List<BobotRole> getAllbobotRole() {
        return bobotRoleJdbcRepository.findBobotRole();
    }

    // Endpoint untuk memperbarui komponen berdasarkan id
    @PutMapping("/update")
    public Map<String, String> updateBobotRole(@RequestBody BobotRole bobotRole) {
        bobotRoleJdbcRepository.updateBobotRole(bobotRole);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Bobot Role berhasil diperbarui");
        return response;
    }



}