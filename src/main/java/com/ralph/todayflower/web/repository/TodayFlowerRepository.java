package com.ralph.todayflower.web.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ralph.todayflower.callapi.dto.NihhsTodayFlowerApiDto;
import com.ralph.todayflower.callapi.service.NihhsTodayFlowerApiService;
import com.ralph.todayflower.web.domain.QTodayFlower;
import com.ralph.todayflower.web.domain.TodayFlower;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class TodayFlowerRepository {

    @PersistenceContext
    private final EntityManager em;
    private final NihhsTodayFlowerApiService nihhsTodayFlowerApiService;

    /**
     * API에서 조회한 TodayFlower 저장
     */
    public Long save(int dataNo) {

        NihhsTodayFlowerApiDto nihhsTodayFlowerApiDto = nihhsTodayFlowerApiService.getTodayFlowerData(dataNo);
        TodayFlower todayFlower = new TodayFlower();
        todayFlower.changeTodayFlower(nihhsTodayFlowerApiDto);

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

        TodayFlower singleResult = null;

        try {
            singleResult = em.createQuery("select tf from TodayFlower tf " +
                            "where tf.month = :month " +
                            "and tf.day = :day", TodayFlower.class)
                            .setParameter("month", month)
                            .setParameter("day", day)
                            .getSingleResult();
        }
        catch (NoResultException e) {
            e.printStackTrace();
        }
        return singleResult;
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

        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        QTodayFlower qTodayFlower = QTodayFlower.todayFlower;

        return jpaQueryFactory
                .selectFrom(qTodayFlower)
                .where(qTodayFlower.lang.contains(lang))
                .orderBy(qTodayFlower.dataNo.desc())
                .fetch();
    }
    public Page<TodayFlower> findByLangPage(Pageable pageable, String lang) {

        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        QTodayFlower qTodayFlower = QTodayFlower.todayFlower;

        //뷰에서 page[1]을 누르면 offset[0]부터 하도록 함.
        long offset = pageable.getOffset() <= 0 ? pageable.getOffset(): pageable.getOffset() - 5;

        List<TodayFlower> result = jpaQueryFactory
                .selectFrom(qTodayFlower)
                .where(qTodayFlower.lang.contains(lang))
                .offset(offset) //offset == pageSize
                .limit(pageable.getPageSize())
                .orderBy(qTodayFlower.dataNo.asc())
                .fetch();

        List<TodayFlower> count = jpaQueryFactory
                .select(qTodayFlower)
                .from(qTodayFlower)
                .where(qTodayFlower.lang.contains(lang))
                .fetch();

        return new PageImpl<>(result, pageable, count.size());
    }


    /***
     * 이름으로 조회
     * @param name
     * @return
     */
    public List<TodayFlower> findByName(String name) {

        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        QTodayFlower qTodayFlower = QTodayFlower.todayFlower;

        return jpaQueryFactory
                .selectFrom(qTodayFlower)
                .where(qTodayFlower.name.contains(name))
                .orderBy(qTodayFlower.dataNo.desc())
                .fetch();
    }

}
