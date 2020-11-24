package com.cj.corona.cjcorona.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoronaUtils {
    public CoronaUtils() {
    }

    public String cal(String curData, String pastData){
        int cur;
        int past;
        try{
            cur = Integer.parseInt(curData);
            past = Integer.parseInt(pastData);
        }catch(NumberFormatException e){
            cur=0;
            past=0;
        }

        String returnVal;
        if(cur-past>=0){
            returnVal = "+"+(cur-past);
        }else{
            returnVal = ""+(cur-past);
        }

        return returnVal;
    }
    //화면에 뿌려줄 데이터 변환
    public String createDt(String createDt){
        log.info("createDt:::"+createDt);
        String[] createDtArr = createDt.split(":");
        return createDtArr[0]+":"+createDtArr[1]+" 기준";
    }
}
