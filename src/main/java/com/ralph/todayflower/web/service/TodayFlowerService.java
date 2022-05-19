package com.ralph.todayflower.web.service;

import com.ralph.todayflower.web.domain.TodayFlower;
import com.ralph.todayflower.web.repository.TodayFlowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
        return todayFlowerRepository.findByLang(lang);
    }
}
