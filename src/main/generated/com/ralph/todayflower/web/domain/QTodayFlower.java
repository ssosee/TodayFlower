package com.ralph.todayflower.web.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTodayFlower is a Querydsl query type for TodayFlower
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTodayFlower extends EntityPathBase<TodayFlower> {

    private static final long serialVersionUID = -1153748892L;

    public static final QTodayFlower todayFlower = new QTodayFlower("todayFlower");

    public final StringPath content = createString("content");

    public final NumberPath<Integer> dataNo = createNumber("dataNo", Integer.class);

    public final StringPath day = createString("day");

    public final StringPath englishName = createString("englishName");

    public final StringPath fileName1 = createString("fileName1");

    public final StringPath fileName2 = createString("fileName2");

    public final StringPath fileName3 = createString("fileName3");

    public final StringPath grow = createString("grow");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgUrl1 = createString("imgUrl1");

    public final StringPath imgUrl2 = createString("imgUrl2");

    public final StringPath imgUrl3 = createString("imgUrl3");

    public final StringPath lang = createString("lang");

    public final StringPath month = createString("month");

    public final StringPath name = createString("name");

    public final StringPath nativePlace = createString("nativePlace");

    public final StringPath publishOrg = createString("publishOrg");

    public final StringPath scientificName = createString("scientificName");

    public final StringPath use = createString("use");

    public QTodayFlower(String variable) {
        super(TodayFlower.class, forVariable(variable));
    }

    public QTodayFlower(Path<? extends TodayFlower> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTodayFlower(PathMetadata metadata) {
        super(TodayFlower.class, metadata);
    }

}

