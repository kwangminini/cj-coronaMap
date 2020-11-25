package com.cj.corona.cjcorona.Service;

import com.cj.corona.cjcorona.domain.infectedPerson.InfectedPerson;
import com.cj.corona.cjcorona.domain.infectedPerson.InfectedPersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class LocationService {
    @Autowired
    private InfectedPersonRepository infectedPersonRepository;

    public HashMap<String, Object> getLocationData(){
        HashMap<String,Object> data = new HashMap<>();
        List<InfectedPerson> infectedPersonList = infectedPersonRepository.findAll();
        data.put("data",infectedPersonList);
        return data;
    }
}
