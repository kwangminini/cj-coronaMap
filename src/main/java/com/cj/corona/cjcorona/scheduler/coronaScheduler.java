package com.cj.corona.cjcorona.scheduler;

import com.cj.corona.cjcorona.Model.CoronaData;
import com.cj.corona.cjcorona.Service.MainService;
import com.cj.corona.cjcorona.domain.covidData.CovidData;
import com.cj.corona.cjcorona.domain.covidData.CovidDataRepository;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Slf4j
public class coronaScheduler {
    @Autowired
    private CovidDataRepository covidDataRepository;
    @Autowired
    private MainService mainService;
    @Builder
    @Scheduled(cron = "* * * 11 * *")
    public void setCoronaDb() throws IOException {  //매일 오전 11시에 공공 데이터를 DB에 세팅
        LocalDate curDate = LocalDate.now();
        String startDate = curDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String endDate = curDate.plusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        List<CoronaData> coronaDataList = mainService.setUrl("20201125","20201125");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        for(CoronaData coronaData : coronaDataList){
            LocalDateTime dateTime = LocalDateTime.parse(coronaData.getCreateDt(),formatter);
            log.info("dateTime:::::"+dateTime);
            CovidData covidData = CovidData.builder()
                    .decideCnt(Integer.parseInt(coronaData.getDecideCnt()))
                    .clearCnt(Integer.parseInt(coronaData.getClearCnt()))
                    .examCnt(Integer.parseInt(coronaData.getExamCnt()))
                    .deathCnt(Integer.parseInt(coronaData.getDeathCnt()))
                    .careCnt(Integer.parseInt(coronaData.getCareCnt()))
                    .createDt(dateTime)
                    .build();
            log.error("========== covidData Insert ==========");
            covidDataRepository.save(covidData);
        }
    }
}
