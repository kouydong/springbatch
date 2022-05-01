package co.kr.apti.springbatch.web.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AptcashListDto {

    private String idx;         //
    private String userid;      // 유저아이디
    private String aptCash;     // 아파트캐쉬
    private String viewDt;      // 확인불가
    private String monthAf2;    // 확인불가

}
