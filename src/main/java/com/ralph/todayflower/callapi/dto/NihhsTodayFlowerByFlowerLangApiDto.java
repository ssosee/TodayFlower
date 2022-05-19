package com.ralph.todayflower.callapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NihhsTodayFlowerByFlowerLangApiDto {
    private String name;
    private String lang;
    private String nativePlace;
    private String fileName1;
    private String imgUrl1;
    private String publishOrg;

    @Builder
    public NihhsTodayFlowerByFlowerLangApiDto(String name, String lang, String nativePlace, String fileName1, String imgUrl1, String publishOrg) {
        this.name = name;
        this.lang = lang;
        this.nativePlace = nativePlace;
        this.fileName1 = fileName1;
        this.imgUrl1 = imgUrl1;
        this.publishOrg = publishOrg;
    }
}
