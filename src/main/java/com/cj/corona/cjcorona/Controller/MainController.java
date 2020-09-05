package com.cj.corona.cjcorona.Controller;

import com.cj.corona.cjcorona.Model.Corona;
import com.cj.corona.cjcorona.Model.CoronaData;
import com.cj.corona.cjcorona.Service.MainService;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class MainController {
    private Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private MainService mainService;
    @Autowired
    private Corona corona;
    List<CoronaData> coronaDataList;
    @GetMapping("/")
    public String main(Model model) throws IOException {
        HashMap<String,Object> result = new HashMap<>();
        coronaDataList = new ArrayList<>();
        coronaDataList = mainService.setUrl("20200827","20200828");
        logger.info("MainController CoronaData::::"+coronaDataList);
        model.addAttribute("decideCnt",coronaDataList.get(0).getDecideCnt());
        model.addAttribute("clearCnt",coronaDataList.get(0).getClearCnt());
        model.addAttribute("examCnt",coronaDataList.get(0).getExamCnt());
        model.addAttribute("deathCnt",coronaDataList.get(0).getDeathCnt());
        model.addAttribute("careCnt",coronaDataList.get(0).getCareCnt());

        return "index";
    }

    @GetMapping("/cheilJedang")
    public String cheilJedang(Model model) throws IOException {
        coronaDataList = new ArrayList<>();
        coronaDataList = mainService.setUrl("20200903","20200904");
        corona.setCurData(coronaDataList.get(0).getDecideCnt(),
                coronaDataList.get(0).getClearCnt(),
                coronaDataList.get(0).getExamCnt(),
                coronaDataList.get(0).getDeathCnt(),
                coronaDataList.get(0).getCareCnt());
        corona.setPastData(coronaDataList.get(1).getDecideCnt(),
                coronaDataList.get(1).getClearCnt(),
                coronaDataList.get(1).getExamCnt(),
                coronaDataList.get(1).getDeathCnt(),
                coronaDataList.get(1).getCareCnt());

        logger.info("cheilJedang CoronaData::::"+coronaDataList);
        model.addAttribute("decideCnt",coronaDataList.get(0).getDecideCnt());
        model.addAttribute("clearCnt",coronaDataList.get(0).getClearCnt());
        model.addAttribute("examCnt",coronaDataList.get(0).getExamCnt());
        model.addAttribute("deathCnt",coronaDataList.get(0).getDeathCnt());
        model.addAttribute("careCnt",coronaDataList.get(0).getCareCnt());

        return "cheilJedang";
    }
}
