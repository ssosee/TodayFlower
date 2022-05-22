package com.ralph.todayflower.web.service;

import com.ralph.todayflower.web.domain.TodayFlower;
import com.ralph.todayflower.web.repository.TodayFlowerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TodayFlowerServiceTest {

    @Autowired
    TodayFlowerService todayFlowerService;
    @Autowired
    TodayFlowerRepository todayFlowerRepository;

    @Test
    @Transactional
    public void 꽃말로_조회_테스트() {
        List<TodayFlower> todayFlowerList = todayFlowerRepository.findByLang("사랑");
        for (TodayFlower todayFlower : todayFlowerList) {
            System.out.println("name = "+todayFlower.getName());
        }
    }
}