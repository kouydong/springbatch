package co.kr.apti.springbatch.step.itemreader;

import co.kr.apti.springbatch.web.dto.AptcashListDto;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//───────────────────────────────────────────────────────────────────────
//  작성일 :   May 1st 2022
//  작성자 :   고의동
//  설명  :   JdbcPagingItemReader 구현방식
//───────────────────────────────────────────────────────────────────────
public class SampleJdbcPagingItemReader {
    //───────────────────────────────────────────────────────────────────────
    //  JDBC 페이징 처리 START
    //───────────────────────────────────────────────────────────────────────
    //  설명
    //───────────────────────────────────────────────────────────────────────
    //  페이징 기법이랑 Chunk로 결과 목록을 반환하여 처리하는 방법
    //  사전에 정의된 개수만큼 데이터베이스가 반환환 레코드로 구성
    //───────────────────────────────────────────────────────────────────────
    //  구현 필수 요소
    //───────────────────────────────────────────────────────────────────────
    //  DataSource : 데이터 소스 구현 필요
    //
    //
    //
    //───────────────────────────────────────────────────────────────────────
/*
    @Bean
    @StepScope
    public JdbcPagingItemReader<AptcashListDto> aptcashListItemReader(DataSource datasour,
                                                                      PagingQueryProvider queryProvider
                                                                      ) {

        Map<String, Object> parameterValues = new HashMap<>();
        parameterValues.put("","");

        return new JdbcPagingItemReaderBuilder<AptcashListDto>()
                .name("JDBC Paging Mechanism for implementing ItemReader")
                .dataSource(datasour)
                .queryProvider(queryProvider)
                .parameterValues(parameterValues)
                .pageSize(10)
                .rowMapper(new Sam)
                .build();

    }

 */
}
