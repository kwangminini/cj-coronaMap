package com.cj.corona.cjcorona.Model;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Corona {
    private String resultCode;  //결과코드
    private String resultMsg;   //결과메세지
    private String numOfRows;   //한 페이지 결과 수
    private String pageNo;      //페이지 수
    private String totalCount;  //전체 결과 수

    private String curDecideCnt;  //현재 확진자 수
    private String curClearCnt;   //현재 격리해제 수
    private String curExamCnt;    //현재 검사진행 수
    private String curDeathCnt;   //현재 사망자 수
    private String curCareCnt;    //현재 치료중 환자

    private String pastDecideCnt;  //하루 전 확진자 수
    private String pastClearCnt;   //하루 전 격리해제 수
    private String pastExamCnt;    //하루 전 검사진행 수
    private String pastDeathCnt;   //하루 전 사망자 수
    private String pastCareCnt;    //하루 전 치료중 환자

    @Builder
    public void setCurData(String curDecideCnt, String curClearCnt, String curExamCnt, String curDeathCnt, String curCareCnt){
        this.curDecideCnt = curDecideCnt;
        this.curClearCnt = curClearCnt;
        this.curExamCnt = curExamCnt;
        this.curDeathCnt = curDeathCnt;
        this.curCareCnt = curCareCnt;
    }
    @Builder
    public void setPastData(String pastDecideCnt, String pastClearCnt, String pastExamCnt, String pastDeathCnt, String pastCareCnt){
        this.pastDecideCnt = pastDecideCnt;
        this.pastClearCnt = pastClearCnt;
        this.pastExamCnt = pastExamCnt;
        this.pastDeathCnt = pastDeathCnt;
        this.pastCareCnt = pastCareCnt;
    }
}
