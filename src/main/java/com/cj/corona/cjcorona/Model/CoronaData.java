package com.cj.corona.cjcorona.Model;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class CoronaData {
    private String resultCode;  //결과코드
    private String resultMsg;   //결과메세지
    private String numOfRows;   //한 페이지 결과 수
    private String pageNo;      //페이지 수
    private String totalCount;  //전체 결과 수수
    private String decideCnt;  //확진자 수
    private String clearCnt;   //격리해제 수
    private String examCnt;    //검사진행 수
    private String deathCnt;   //사망자 수
    private String careCnt;    //치료중 환자
    private String createDt;   //생성일

    @Builder
    public CoronaData (String decideCnt, String clearCnt, String examCnt, String deathCnt, String careCnt, String createDt){
        this.decideCnt = decideCnt;
        this.clearCnt = clearCnt;
        this.examCnt = examCnt;
        this.deathCnt = deathCnt;
        this.careCnt = careCnt;
        this.createDt = createDt;
    }
}
