package com.ralph.todayflower.web.controller;

import com.ralph.todayflower.callapi.service.NihhsTodayFlowerApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TodayFlowerController {
    private final NihhsTodayFlowerApiService dto;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/todayFlowerByDate")
    public String getTodayFlower(Model model) {
        //todayFlowerService.save(month, day);
        model.addAttribute("dateForm", new DateForm());
        model.addAttribute("todayFlower", dto.getTodayFlower());

        return "todayFlowerByDate";
    }

    @PostMapping("/todayFlowerByDate")
    public String postTodayFlower(DateForm dateForm) {

        dto.changeTodayFlowerDate(dateForm.getMonth(), dateForm.getDay());

        return "redirect:/todayFlowerByDate";
    }

}
