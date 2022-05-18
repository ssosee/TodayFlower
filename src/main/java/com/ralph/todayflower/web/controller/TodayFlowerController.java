package com.ralph.todayflower.web.controller;

import com.ralph.todayflower.callapi.service.NihhsTodayFlowerApiService;
import com.ralph.todayflower.web.service.TodayFlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class TodayFlowerController {
    private final NihhsTodayFlowerApiService dto;
    private final TodayFlowerService todayFlowerService;
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/todayFlowerByDate")
    public String todayFlowerByDate(Model model) {
        //todayFlowerService.save(month, day);
        model.addAttribute("dateForm", new DateForm());
        model.addAttribute("todayFlower", dto.getTodayFlowerByDate());
        return "todayFlowerByDate";
    }

    @PostMapping("/todayFlowerByDate")
    public String postTodayFlower(DateForm dateForm) {

        dto.changeTodayFlowerDate(dateForm.getMonth(), dateForm.getDay());
        todayFlowerService.save(dateForm.getMonth(), dateForm.getDay());

        return "redirect:/todayFlowerByDate";
    }

//    @GetMapping("/todayFlowerByFlowerLang")
//    public String todayFlowerByFlowerLang(Model model) {
//        model.addAttribute()
//    }
}
