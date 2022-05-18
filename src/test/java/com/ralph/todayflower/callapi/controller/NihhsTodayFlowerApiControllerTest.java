package com.ralph.todayflower.callapi.controller;

import com.ralph.todayflower.callapi.service.NihhsTodayFlowerApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NihhsTodayFlowerApiControllerTest {

    @Autowired
    NihhsTodayFlowerApiController nihhsTodayFlowerApiController;
    @Autowired
    NihhsTodayFlowerApiService nihhsTodayFlowerApiService;

    @Test
    public void getTodayFlowerListByFlowerLang() {
//        nihhsTodayFlowerApiService.changeTodayFlowerLang("사랑");
//        nihhsTodayFlowerApiService.getTodayFlowerByFlowerLang();
        System.out.println("금요일에 만나요 = "+nihhsTodayFlowerApiController.getTodayFlowerListByFlowerLang("사랑").block());
        //System.out.println("목요일에 만나요 = "+nihhsTodayFlowerApiController.getTodayFlowerByDataNo(1).block());
        //System.out.println("신영이 잘자 = "+nihhsTodayFlowerApiController.getTodayFlowerByDate(null, null).block());
    }
}