package com.ralph.todayflower.web.controller;

import com.ralph.todayflower.callapi.service.NihhsTodayFlowerApiService;
import com.ralph.todayflower.web.controller.form.TodayFlowerForm;
import com.ralph.todayflower.web.domain.TodayFlower;
import com.ralph.todayflower.web.service.TodayFlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

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
    public String todayFlowerByDate(@ModelAttribute("form") @Valid SearchTodayFlowerByDate form, Model model) {

        TodayFlower todayFlower = todayFlowerService.findByDate(form.getMonth(), form.getDay());
        model.addAttribute("todayFlower", new TodayFlowerForm(todayFlower));

        return "todayFlowerByDate";
    }

    @GetMapping("/todayFlowerByFlowerLang")
    public String todayFlowerByFlowerLang(Model model) {
        model.addAttribute("todayFlowerByFlowerLang", dto.getTodayFlowerByFlowerLang());

        return "todayFlowerByFlowerLang";
    }
}
