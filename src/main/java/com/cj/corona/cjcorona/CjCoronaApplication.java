package com.cj.corona.cjcorona;

import com.cj.corona.cjcorona.scheduler.CoronaDataScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CjCoronaApplication {

    @SuppressWarnings("unused")
    private final CoronaDataScheduler coronaDataScheduler;
    @Autowired
    public CjCoronaApplication(CoronaDataScheduler coronaDataScheduler) {
        this.coronaDataScheduler = coronaDataScheduler;
    }

    public static void main(String[] args) {
        SpringApplication.run(CjCoronaApplication.class, args);
    }

}
