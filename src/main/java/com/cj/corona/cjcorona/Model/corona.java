package com.cj.corona.cjcorona.Model;


import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class corona {
    private String resultCode;  //결과코드
    private String resultMsg;   //결과메세지
    private String numOfRows;   //한 페이지 결과 수
    private String pageNo;      //페이지 수
    private String totalCount;  //전체 결과 수
    private String DECIDE_CNT;  //확진자 수
    private String CLEAR_CNT;   //격리해제 수
    private String EXAM_CNT;    //검사진행 수
    private String DEATH_CNT;   //사망자 수
    private String CARE_CNT;    //치료중 환자

}
