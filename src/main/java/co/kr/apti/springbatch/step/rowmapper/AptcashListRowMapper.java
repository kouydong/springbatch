package co.kr.apti.springbatch.step.rowmapper;

import co.kr.apti.springbatch.web.dto.AptcashListDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//───────────────────────────────────────────────────────────────────────
//  작성일 :   Apr 30th 2022
//  작성자 :   고의동
//  설명   :   JDBC Cursor Item Reader 처리를 위해 RowMapper 인터페이스를 구현
//───────────────────────────────────────────────────────────────────────

public class AptcashListRowMapper implements RowMapper<AptcashListDto> {

    @Override
    public AptcashListDto mapRow(ResultSet resuSet, int rowNumb) throws SQLException {
        //───────────────────────────────────────────────────────────────────────
        AptcashListDto aptcashListDto = new AptcashListDto();
        //───────────────────────────────────────────────────────────────────────
        //  ResultSet에서 결과값을 받아서 객체에 전달
        //───────────────────────────────────────────────────────────────────────
        aptcashListDto.setIdx       (resuSet.getString("idx"        ));
        aptcashListDto.setUserid    (resuSet.getString("userId"     ));
        aptcashListDto.setAptCash   (resuSet.getString("aptCash"    ));
        aptcashListDto.setViewDt    (resuSet.getString("viewDt"     ));
        aptcashListDto.setMonthAf2  (resuSet.getString("monthAf2"   ));
        //───────────────────────────────────────────────────────────────────────
        return aptcashListDto;
        //───────────────────────────────────────────────────────────────────────
    }
}

