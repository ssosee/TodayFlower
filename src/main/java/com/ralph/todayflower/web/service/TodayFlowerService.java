package com.ralph.todayflower.web.service;

import com.ralph.todayflower.web.domain.TodayFlower;
import com.ralph.todayflower.web.repository.TodayFlowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodayFlowerService {

    private final TodayFlowerRepository todayFlowerRepository;

    /***
     * DB에서 오늘의 꽃 조회
     * @param month
     * @param day
     * @return
     */
    public TodayFlower findByDate(String month, String day) {
        if(month == null || day == null) {
            LocalDateTime localDateTime = LocalDateTime.now();
            month = String.format("%d", localDateTime.getMonthValue());
            day = String.format("%d", localDateTime.getDayOfMonth());
        }

        return todayFlowerRepository.findByMonthDay(month, day);
    }

    @Transactional
    public void saveAll(int dataNo) {
        todayFlowerRepository.save(dataNo);
    }

    public List<TodayFlower> findByLang(String lang) {

        if(StringUtils.hasText(lang)) {
            return todayFlowerRepository.findByLang(lang);
        }

        List<TodayFlower> todayFlowerList = new ArrayList<>();
        TodayFlower todayFlower = new TodayFlower();
        todayFlower.defaultTodayFlower(0, "/image/나태주.png", "풀꽃(나태주)", "자세히 봐야 이쁘다.\n오래보아야 사랑스럽다.\n너도 그렇다.");
        todayFlowerList.add(todayFlower);

        return todayFlowerList;
    }

    public List<TodayFlower> findByName(String name) {
        return todayFlowerRepository.findByName(name);
    }
}
