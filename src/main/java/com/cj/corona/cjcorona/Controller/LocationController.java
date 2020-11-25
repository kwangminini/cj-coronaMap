package com.cj.corona.cjcorona.Controller;

import com.cj.corona.cjcorona.Service.LocationService;
import com.cj.corona.cjcorona.domain.infectedPerson.InfectedPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping("/getLocationData")
    public @ResponseBody
    HashMap<String, Object> getLocationData(){
        return locationService.getLocationData();
    }
}
