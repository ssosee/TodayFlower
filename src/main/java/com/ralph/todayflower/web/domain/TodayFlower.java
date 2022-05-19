package com.ralph.todayflower.web.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

/***
 * 오늘의 꽃 정보 상세기능 명세
 */
@Entity
@Getter
public class TodayFlower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int dataNo;
    private String month;
    private String day;
    private String name;
    private String scientificName;
    private String englishName;
    private String lang;
    @Lob
    private String content;
    @Lob
    private String use;
    @Lob
    private String grow;
    @Lob
    private String nativePlace;
    @Lob
    private String fileName1;
    @Lob
    private String fileName2;
    @Lob
    private String fileName3;
    @Lob
    private String imgUrl1;
    @Lob
    private String imgUrl2;
    @Lob
    private String imgUrl3;
    private String publishOrg;

    @Builder
    public TodayFlower(Long id, int dataNo, String month, String day, String name, String scientificName, String englishName, String lang, String content, String use, String grow, String nativePlace, String fileName1, String fileName2, String fileName3, String imgUrl1, String imgUrl2, String imgUrl3, String publishOrg) {
        this.id = id;
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

    public TodayFlower() {

    }
}
