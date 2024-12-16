package com.example.tubesRPL.BAP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BAPController {

    private final BAPDataRepository taDataRepository;

    @Autowired
    public BAPController(BAPDataRepository taDataRepository) {
        this.taDataRepository = taDataRepository;
    }

    @GetMapping("/bap")
    public String getBAPPage(Model model) {
        List<BAPData> taDataList = taDataRepository.findAll();
        model.addAttribute("taDataList", taDataList);
        return "bapSidang";
    }
}