package co.kr.apti.springbatch.step.itemreader;

import co.kr.apti.springbatch.domain.entity.PushFCM;
//import co.kr.apti.springbatch.step.provider.FingerPushQueryProvider;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import javax.persistence.EntityManagerFactory;

//───────────────────────────────────────────────────────────────────────
//  작성일 :   Apr 30th 2022
//  작성자 :   고의동
//  설명  :   JPA를 통한 ItemReader 구현은 2개
//          1. JpaPagingItemReader를 통한 구현 방법
//          2. Provider를 통한 구현방법
//───────────────────────────────────────────────────────────────────────

public class FingerPushItemReader {
/*
    @Bean
    @StepScope
    //───────────────────────────────────────────────────────────────────────
    //  JDBC
    //───────────────────────────────────────────────────────────────────────


    //───────────────────────────────────────────────────────────────────────
    //  JpaPagingItemReaderBuilder를 통한 ItemReader 구현방법
    //───────────────────────────────────────────────────────────────────────
    public JpaPagingItemReader<PushFCM> pushFCMItemReader(
            EntityManagerFactory entityManagerFactory) {

    return new JpaPagingItemReaderBuilder<PushFCM>()
                .name("PushFCM")
                .entityManagerFactory(entityManagerFactory)
                //.queryString("")
                //.parameterValues(Collections.singletonMap("key","value")
                .build();
    }



    //───────────────────────────────────────────────────────────────────────
    //  Provider를 통한 ItemReader 구현방법
    //───────────────────────────────────────────────────────────────────────
    /*
    public JpaPagingItemReader<pushFCM> pushFCMItemReader(
            EntityManagerFactory entityManagerFactory) {

        FingerPushQueryProvider queryProvider = new FingerPushQueryProvider();
        // 설정 값이 존재시 set 메서드 생성 필요

        return new JpaPagingItemReaderBuilder<PushFCM>()
                .name("PushFCM")
                .entityManagerFactory(entityManagerFactory)
                .queryProvider(queryProvider)
                //.parameterValues(Collections.singletonMap("key","value")
                .build();
    }
    */
    //───────────────────────────────────────────────────────────────────────
}
