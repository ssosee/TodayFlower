package com.ralph.todayflower.web.repository;

import com.ralph.todayflower.callapi.dto.NihhsTodayFlowerApiDto;
import com.ralph.todayflower.callapi.service.NihhsTodayFlowerApiService;
import com.ralph.todayflower.web.domain.TodayFlower;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodayFlowerRepository {

    @PersistenceContext
    private final EntityManager em;
    private final NihhsTodayFlowerApiService nihhsTodayFlowerApiService;

    /**
     * API에서 조회한 TodayFlower 저장
     */
    public Long save(String month, String day) {

        NihhsTodayFlowerApiDto nihhsTodayFlowerApiDto = nihhsTodayFlowerApiService.getTodayFlowerByDate();

        TodayFlower todayFlower = TodayFlower.builder()
                .dataNo(nihhsTodayFlowerApiDto.getDataNo())
                .content(nihhsTodayFlowerApiDto.getContent())
                .day(nihhsTodayFlowerApiDto.getDay())
                .englishName(nihhsTodayFlowerApiDto.getEnglishName())
                .fileName1(nihhsTodayFlowerApiDto.getFileName1())
                .fileName2(nihhsTodayFlowerApiDto.getFileName2())
                .fileName3(nihhsTodayFlowerApiDto.getFileName3())
                .grow(nihhsTodayFlowerApiDto.getGrow())
                .imgUrl1(nihhsTodayFlowerApiDto.getImgUrl1())
                .imgUrl2(nihhsTodayFlowerApiDto.getImgUrl2())
                .imgUrl3(nihhsTodayFlowerApiDto.getImgUrl3())
                .month(nihhsTodayFlowerApiDto.getMonth())
                .name(nihhsTodayFlowerApiDto.getName())
                .nativePlace(nihhsTodayFlowerApiDto.getNativePlace())
                .publishOrg(nihhsTodayFlowerApiDto.getPublishOrg())
                .scientificName(nihhsTodayFlowerApiDto.getScientificName())
                .use(nihhsTodayFlowerApiDto.getUse())
                .lang(nihhsTodayFlowerApiDto.getLang())
                .build();

        em.persist(todayFlower);

        return todayFlower.getId();
    }

    /**
     * 조회
     */
    public TodayFlower findById(Long todayFlowerId) {
        return em.find(TodayFlower.class, todayFlowerId);
    }

    /***
     * 오늘의 꽃 조회
     * @param month default 현재 월
     * @param day default 현재 일
     * @return
     */
    public TodayFlower findByMonthDay(String month, String day) {
        return em.createQuery("select tf from TodayFlower tf " +
                "where tf.month = :month " +
                "and tf.day = :day", TodayFlower.class)
                .setParameter("month", month)
                .setParameter("day", day)
                .getSingleResult();
    }

    /***
     * 전체 조회
     * @return
     */
    public List<TodayFlower> findAll() {
        return em.createQuery("select tf from TodayFlower tf", TodayFlower.class)
                .getResultList();
    }

    /***
     * 꽃말로 조회
     * @param lang
     * @return
     */
    public List<TodayFlower> findByLang(String lang) {
        return em.createQuery("select tf from TodayFlower tf " +
                "where tf.lang like :lang", TodayFlower.class)
                .setParameter("lang", lang)
                .getResultList();
    }



}
