package com.ralph.todayflower.callapi.controller;

import lombok.Getter;

@Getter
public enum SearchType {
    flowNm(1),
    fSctNm(2), //학명
    fEngNm(3),
    flowLang(4),
    fContent(5),
    fUse(6),
    fGrow(7),
    fType(8),
    fAll(9);

    private int value;

    SearchType(int value) {
        this.value = value;
    }
}
