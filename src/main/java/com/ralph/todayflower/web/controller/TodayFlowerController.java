package com.ralph.todayflower.web.controller;

import com.ralph.todayflower.service.NihhsTodayFlowerApiService;
import com.ralph.todayflower.web.service.TodayFlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TodayFlowerController {
    private final TodayFlowerService todayFlowerService;
    private final NihhsTodayFlowerApiService dto;

    @GetMapping("/todayFlower")
    public String getTodayFlower(Model model) {
        //todayFlowerService.save(month, day);
        model.addAttribute("dateForm", new DateForm());
        model.addAttribute("todayFlower", dto.getTodayFlower());

        return "todayFlower";
    }

    @PostMapping("/todayFlower")
    public String postTodayFlower(DateForm dateForm) {

        dto.changeTodayFlowerDate(dateForm.getMonth(), dateForm.getDay());

        return "redirect:/todayFlower";
    }

}
