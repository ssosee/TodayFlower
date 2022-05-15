package com.ralph.todayflower.externalapi;

import com.ralph.todayflower.callapi.controller.NihhsTodayFlowerApiController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebFluxTest(NihhsTodayFlowerApiController.class)
public class NihhsTodayFlowerApiControllerTest {
    @Autowired
    NihhsTodayFlowerApiController nihhsTodayFlowerApiController;

    @Test
    public void test() {

    }
}