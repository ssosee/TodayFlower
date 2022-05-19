package com.ralph.todayflower.web.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter @Setter
public class SearchTodayFlowerByDate {
    @Positive
    private String month;
    @Positive
    private String day;
}
