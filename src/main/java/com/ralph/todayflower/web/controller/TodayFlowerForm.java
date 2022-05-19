package com.ralph.todayflower.web.controller;

import com.ralph.todayflower.web.domain.TodayFlower;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;

@Getter @Setter
public class TodayFlowerForm {
    private String month;
    private String day;
    private String name;
    private String lang;
    private String content;
    private String grow;
    private String nativePlace;
    private String fileName1;
    private String fileName2;
    private String fileName3;
    private String imgUrl1;
    private String imgUrl2;
    private String imgUrl3;
    private String publishOrg;

    public TodayFlowerForm(TodayFlower todayFlower) {

        if(todayFlower != null) {
            this.month = todayFlower.getMonth();
            this.day = todayFlower.getDay();
            this.name = todayFlower.getName();
            this.lang = todayFlower.getLang();
            this.content = todayFlower.getContent();
            this.grow = todayFlower.getGrow();
            this.nativePlace = todayFlower.getNativePlace();
            this.fileName1 = todayFlower.getFileName1();
            this.fileName2 = todayFlower.getFileName2();
            this.fileName3 = todayFlower.getFileName3();
            this.imgUrl1 = todayFlower.getImgUrl1();
            this.imgUrl2 = todayFlower.getImgUrl2();
            this.imgUrl3 = todayFlower.getImgUrl3();
            this.publishOrg = todayFlower.getPublishOrg();
        }
    }
}
