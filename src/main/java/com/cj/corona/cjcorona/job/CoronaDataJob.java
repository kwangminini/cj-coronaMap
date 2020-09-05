package com.cj.corona.cjcorona.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDate;

@Slf4j
public class CoronaDataJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("----------------------Job------------------");
//        LocalDate localDate = LocalDate.now();
//        log.info("localData:::"+localDate);
    }
}
