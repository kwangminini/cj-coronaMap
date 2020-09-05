package com.cj.corona.cjcorona.scheduler;

import com.cj.corona.cjcorona.job.CoronaDataJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CoronaDataScheduler {
    private SchedulerFactory schedulerFactory;
    private Scheduler scheduler;

    @PostConstruct
    public void start() throws SchedulerException{
        schedulerFactory = new StdSchedulerFactory();
        scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        //job 지정
        JobDetail job = JobBuilder.newJob(CoronaDataJob.class).withIdentity("apiJob").build();
        //trigger 생성
        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule("*/10 * * * * ?")).build();

        scheduler.scheduleJob(job,trigger);
    }
}
