package com.cj.corona.cjcorona.job;

import com.cj.corona.cjcorona.Model.CoronaData;
import com.cj.corona.cjcorona.Service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
public class CoronaDataJob implements Job {
    @Autowired
    private MainService mainService;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        List<CoronaData> coronaDataList;
        log.info("----------------------Job------------------");
        LocalDate curDate = LocalDate.now();
        String startDate = curDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String endDate = curDate.plusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        log.info("startDate:::"+startDate);
        log.info("localData:::"+startDate);

//        coronaDataList = mainService.setUrl(localDate,);

    }
}
