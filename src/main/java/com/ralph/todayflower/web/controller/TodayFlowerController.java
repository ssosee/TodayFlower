package com.ralph.todayflower.web.controller;

import com.ralph.todayflower.callapi.service.NihhsTodayFlowerApiService;
import com.ralph.todayflower.web.domain.TodayFlower;
import com.ralph.todayflower.web.service.TodayFlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String todayFlowerByDate(@ModelAttribute("form") TodayFlowerByDateForm form, Model model) {
        //todayFlowerService.save(month, day);


        //model.addAttribute("dateForm", new TodayFlowerByDateForm());
        model.addAttribute("todayFlower", todayFlowerService.findByDate(form.getMonth(), form.getDay()));
        return "todayFlowerByDate";
    }

    @PostMapping("/todayFlowerByDate")
    public String postTodayFlower(TodayFlowerByDateForm form) {

        //dto.changeTodayFlowerDate(form.getMonth(), form.getDay());
        todayFlowerService.findByDate(form.getMonth(), form.getDay());

        return "redirect:/todayFlowerByDate";
    }

    @GetMapping("/todayFlowerByFlowerLang")
    public String todayFlowerByFlowerLang(Model model) {
        model.addAttribute("todayFlowerByFlowerLang", dto.getTodayFlowerByFlowerLang());

        return "todayFlowerByFlowerLang";
    }
}
