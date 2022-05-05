package com.ralph.todayflower.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class NihhsTodayFlowerApiDto {
    private int dataNo;
    private String month;
    private String day;
    private String name;
    private String scientificName;
    private String englishName;
    private String lang;
    private String content;
    private String use;
    private String grow;
    private String nativePlace;
    private String fileName1;
    private String fileName2;
    private String fileName3;
    private String imgUrl1;
    private String imgUrl2;
    private String imgUrl3;
    private String publishOrg;

    @Builder
    public NihhsTodayFlowerApiDto(int dataNo, String month, String day, String name, String scientificName, String englishName, String lang, String content, String use, String grow, String nativePlace, String fileName1, String fileName2, String fileName3, String imgUrl1, String imgUrl2, String imgUrl3, String publishOrg) {
        this.dataNo = dataNo;
        this.month = month;
        this.day = day;
        this.name = name;
        this.scientificName = scientificName;
        this.englishName = englishName;
        this.lang = lang;
        this.content = content;
        this.use = use;
        this.grow = grow;
        this.nativePlace = nativePlace;
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
        this.fileName3 = fileName3;
        this.imgUrl1 = imgUrl1;
        this.imgUrl2 = imgUrl2;
        this.imgUrl3 = imgUrl3;
        this.publishOrg = publishOrg;
    }
}
