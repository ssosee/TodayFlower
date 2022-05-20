package com.ralph.todayflower.web.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Getter @Setter
public class SearchTodayFlowerByDate {
    @Positive(message = "숫자를 입력 해야합니다. ex) 2")
    private String month;
    @Positive(message = "숫자를 입력 해야합니다. ex) 16")
    private String day;
}
