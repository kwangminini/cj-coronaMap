//package com.cj.corona.cjcorona.job;
//
//import com.cj.corona.cjcorona.Model.CoronaData;
//import com.cj.corona.cjcorona.Service.MainService;
//import lombok.extern.slf4j.Slf4j;
//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//@Slf4j
//@Component
//public class CoronaDataJob implements Job {
//    @Autowired
//    private MainService mainService;
//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        List<CoronaData> coronaDataList = new ArrayList<>();
//        log.info("----------------------Job------------------");
//        LocalDate curDate = LocalDate.now();
//        String startDate = curDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//        String endDate = curDate.plusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//        log.info("startDate:::"+startDate);
//        log.info("endDate:::"+endDate);
//
//        try {
//            coronaDataList = mainService.setUrl("20201124","20201125");
//            for (CoronaData corona:coronaDataList) {
//                log.info("corona:::"+corona.toString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}
