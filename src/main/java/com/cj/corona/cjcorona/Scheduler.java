package com.cj.corona.cjcorona;

import com.cj.corona.cjcorona.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    @Autowired
    private MainService mainService;
    public void run(){

    }
}
