package co.kr.apti.springbatch.step.itemreader;

import co.kr.apti.springbatch.step.rowmapper.AptcashListRowMapper;
import co.kr.apti.springbatch.web.dto.AptcashListDto;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import javax.sql.DataSource;
//───────────────────────────────────────────────────────────────────────
//  작성일 :   Apr 30th 2022
//  작성자 :   고의동
//  설명  :   JdbcCursorItemReader 구현방식
//───────────────────────────────────────────────────────────────────────
public class ApticashListJdbcCursorItemReader {
    //───────────────────────────────────────────────────────────────────────
    //  JDBC 커서 처리 방식
    //───────────────────────────────────────────────────────────────────────
    //  설명
    //───────────────────────────────────────────────────────────────────────
    //  데이터결과값을 하나씩 전달받아 도메인 객체에 필드로 매핑
    //  도메인 객체에 RowMapper 인터페이스를 구현해야 함(e.g : ApticashListRowMapper 참조)
    //  Binding 변수가 있는 경우 preparedStatementSetter 구현필요
    //───────────────────────────────────────────────────────────────────────
    //  구현 필요 요소
    //───────────────────────────────────────────────────────────────────────
    //  도메인 객체에 RowMapper 인터페이스를 구현해야 함(e.g : ApticashListRowMapper 참조)
    //  데이터소스(Datasource)
    //  SQL
    //───────────────────────────────────────────────────────────────────────
    //  구현 선택 요소
    //───────────────────────────────────────────────────────────────────────
    //  preparedStatementSetter : 바인딩 변수가 있는 경우 구현 필요
    //───────────────────────────────────────────────────────────────────────
    @Bean
    public JdbcCursorItemReader<AptcashListDto> aptcashListItemReader(DataSource datasource){
        //───────────────────────────────────────────────────────────────────────
        StringBuffer sql = new StringBuffer();
        //───────────────────────────────────────────────────────────────────────
        sql.append("select                                                                          ");
        sql.append("        idx                                         as idx,                     ");
        sql.append("        userid                                      as userid,                  ");
        sql.append("        aptCash                                     as aptCash,                 ");
        sql.append("        convert(char(8),reg,112)                    as viewDt,                  ");
        sql.append("        convert(char(6),dateAdd(mm,2,reg),112)+'01' as monthAf2                 ");
        sql.append("  from aptCash_list l                                                           ");
        sql.append(" where gubu='1' and aptCashKind='20' and chgGubu='N'                            ");
        sql.append("   and reg between dateadd(mi,-32,getDate()) and getDate()                      ");
        sql.append("   and idx not in (select etcKey from mbl_notification_list where notiNo = ?    ");
        sql.append("   and viewDt = convert(char(8),l.reg,112) and etcKey is not null)              ");
        //───────────────────────────────────────────────────────────────────────
        return new JdbcCursorItemReaderBuilder<AptcashListDto>()
                .name("JDBC Cursor Mechanism for implementing ItemReader")
                .dataSource(datasource)                                     // 필수필드
                .sql(sql.toString())                                        // 필수필드(SQL)
                .rowMapper(new AptcashListRowMapper())                      // 필수필드(RowMapper 구현클래스)
                .preparedStatementSetter(sampleSetter(null))
                .build();
    }
    //───────────────────────────────────────────────────────────────────────

    @Bean
    @StepScope
    public ArgumentPreparedStatementSetter sampleSetter(String[] bindParam) {
        return new ArgumentPreparedStatementSetter(new Object[] {bindParam});
    }
    //───────────────────────────────────────────────────────────────────────
    //  JDBC 커서 처리 방식 END
    //───────────────────────────────────────────────────────────────────────

}
