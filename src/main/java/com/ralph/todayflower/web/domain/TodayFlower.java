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
    @GeneratedValue
    private Long id;
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

}
