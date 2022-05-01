package co.kr.apti.springbatch.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PushFingerDto {

    private String mblPushToken;
    private String userid;
    private String notiNo;
    private String title;
    private String pushMessage;
    private String nowHHMM;

}
