package com.cj.corona.cjcorona.Controller;

import com.cj.corona.cjcorona.Model.corona;
import com.cj.corona.cjcorona.Service.mainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Controller
public class mainController {
    private Logger logger = LoggerFactory.getLogger(mainController.class);
    @Autowired
    private mainService mainService;
    @GetMapping("/")
    public String main(Model model) throws IOException {
        HashMap<String,Object> result = new HashMap<>();

//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        factory.setConnectTimeout(5000);
//        factory.setReadTimeout(5000);
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders header = new HttpHeaders();
//
//        header.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
//        HttpEntity<?> entity = new HttpEntity<>(header);
//        String url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson";
//        String serviceKey="LVzdyLr3MIY%2BnwjZZJS92Y0Lr9e%2FXPXMTu8RnUBu3QxTSaIXyASoF8eGsfFgsPHkRkNTdJzl06HC38YySRAIkA%3D%3D";
//        String decodeServiceKey= URLEncoder.encode(serviceKey,"UTF-8");
//        String encodeServiceKey= URLEncoder.encode("serviceKey","UTF-8");
//        String encodeNumOfRows = URLEncoder.encode("numOfRows","UTF-8");
//        String encodePageNo = URLEncoder.encode("pageNo","UTF-8");
//        String encodeStartCreateDt = URLEncoder.encode("startCreateDt","UTF-8");
//        String encodeEndCreateDt = URLEncoder.encode("endCreateDt","UTF-8");
//        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url)
//                .queryParam(encodeServiceKey,decodeServiceKey)
//                .queryParam(encodeNumOfRows,URLEncoder.encode("1","UTF-8"))
//                .queryParam(encodePageNo,URLEncoder.encode("1","UTF-8"))
//                .queryParam(encodeStartCreateDt,URLEncoder.encode("20200826","UTF-8"))
//                .queryParam(encodeEndCreateDt,URLEncoder.encode("20200826","UTF-8"))
//                .build(false);
//        logger.info("decodeServiceKey::"+decodeServiceKey);
//        logger.info("uriComoponents:::"+uriComponents.toString());
//        logger.info("uriComoponents:::"+uriComponents.toUriString());
//
//        Object resultMap = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET,new HttpEntity<String>(header), String.class);
//        logger.info("resultMap::::"+resultMap);
        mainService.setUrl();

        return "index";
    }
}
