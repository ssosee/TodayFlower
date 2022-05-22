package com.ralph.todayflower.web.domain;

import com.ralph.todayflower.callapi.dto.NihhsTodayFlowerApiDto;
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
    private String fileName1;
    private String fileName2;
    private String fileName3;
    private String imgUrl1;
    private String imgUrl2;
    private String imgUrl3;
    private String publishOrg;

    public void changeTodayFlower(NihhsTodayFlowerApiDto dto) {
        this.dataNo = dto.getDataNo();
        this.month = dto.getMonth();
        this.day = dto.getDay();
        this.name = dto.getName();
        this.scientificName = dto.getScientificName();
        this.englishName = dto.getEnglishName();
        this.lang = dto.getLang();
        this.content = dto.getContent();
        this.use = dto.getUse();
        this.grow = dto.getGrow();
        this.nativePlace = dto.getNativePlace();
        this.fileName1 = dto.getFileName1();
        this.fileName2 = dto.getFileName2();
        this.fileName3 = dto.getFileName3();
        this.imgUrl1 = dto.getImgUrl1();
        this.imgUrl2 = dto.getImgUrl2();
        this.imgUrl3 = dto.getImgUrl3();
        this.publishOrg = dto.getPublishOrg();
    }

    public void defaultTodayFlower(int dataNo, String imgUrl1, String name, String lang) {
        this.dataNo = dataNo;
        this.imgUrl1 = imgUrl1;
        this.name = name;
        this.lang = lang;
    }
}
