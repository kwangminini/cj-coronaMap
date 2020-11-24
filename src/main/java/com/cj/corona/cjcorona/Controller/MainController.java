package com.cj.corona.cjcorona.Controller;

import com.cj.corona.cjcorona.Model.Corona;
import com.cj.corona.cjcorona.Model.CoronaData;
import com.cj.corona.cjcorona.Service.MainService;
import com.cj.corona.cjcorona.utils.CoronaUtils;
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
    private CoronaUtils coronaUtils = new CoronaUtils();
    @GetMapping("/")
    public String main(Model model) throws IOException {
        HashMap<String,Object> result = new HashMap<>();
        coronaDataList = new ArrayList<>();
        coronaDataList = mainService.setUrl("20201105","20201106");
        model.addAttribute("decideCnt",coronaDataList.get(0).getDecideCnt());
        model.addAttribute("clearCnt",coronaDataList.get(0).getClearCnt());
        model.addAttribute("examCnt",coronaDataList.get(0).getExamCnt());
        model.addAttribute("deathCnt",coronaDataList.get(0).getDeathCnt());
        model.addAttribute("careCnt",coronaDataList.get(0).getCareCnt());
        model.addAttribute("createDt",coronaUtils.createDt(coronaDataList.get(0).getCreateDt()));   //데이터 생성 기준
        return "index";
    }

    @GetMapping("/cheilJedang")
    public String cheilJedang(Model model) throws IOException {
        coronaDataList = new ArrayList<>();
        coronaDataList = mainService.setUrl("20200911","20200912");
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


        logger.info("cheilJedang getDecideCnt::::"+coronaUtils.cal(corona.getCurDecideCnt(),corona.getPastDecideCnt()));
        logger.info("cheilJedang getClearCnt::::"+coronaUtils.cal(corona.getCurClearCnt(),corona.getPastClearCnt()));
        logger.info("cheilJedang getExamCnt::::"+coronaUtils.cal(corona.getCurExamCnt(),corona.getPastExamCnt()));
        logger.info("cheilJedang getDeathCnt::::"+coronaUtils.cal(corona.getCurDeathCnt(),corona.getPastDeathCnt()));
        logger.info("cheilJedang getCareCnt::::"+coronaUtils.cal(corona.getCurCareCnt(),corona.getPastCareCnt()));
        model.addAttribute("decideCnt",coronaDataList.get(0).getDecideCnt());
        model.addAttribute("decideCntRate",coronaUtils.cal(corona.getCurDecideCnt(),corona.getPastDecideCnt()));
        model.addAttribute("clearCnt",coronaDataList.get(0).getClearCnt());
        model.addAttribute("clearCntRate",coronaUtils.cal(corona.getCurClearCnt(),corona.getPastClearCnt()));
        model.addAttribute("examCnt",coronaDataList.get(0).getExamCnt());
        model.addAttribute("examCntRate",coronaUtils.cal(corona.getCurExamCnt(),corona.getPastExamCnt()));
        model.addAttribute("deathCnt",coronaDataList.get(0).getDeathCnt());
        model.addAttribute("deathCntRate",coronaUtils.cal(corona.getCurDeathCnt(),corona.getPastDeathCnt()));
        model.addAttribute("careCnt",coronaDataList.get(0).getCareCnt());
        model.addAttribute("careCntRate",coronaUtils.cal(corona.getCurCareCnt(),corona.getPastCareCnt()));
        model.addAttribute("createDt",coronaUtils.createDt(coronaDataList.get(0).getCreateDt()));
        return "cheilJedang";
    }
}
