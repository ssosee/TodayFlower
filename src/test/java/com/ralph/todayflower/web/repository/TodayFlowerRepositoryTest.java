package com.ralph.todayflower.web.repository;

import com.ralph.todayflower.web.domain.TodayFlower;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TodayFlowerRepositoryTest {

    @Autowired
    TodayFlowerRepository todayFlowerRepository;

    @Test
    public void 페이징_테스트() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<TodayFlower> todayFlowers = todayFlowerRepository.findByLangPage(pageRequest, "사랑");
        assertThat(todayFlowers.get().count()).isEqualTo(10);
    }

}