package com.cj.corona.cjcorona.Service;

import com.cj.corona.cjcorona.Model.CoronaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    private Logger logger = LoggerFactory.getLogger(MainService.class);
    private List<CoronaData> coronaDataList;
    public List<CoronaData> setUrl(String startDt, String endDt) throws IOException {
        coronaDataList=new ArrayList<>();
        StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson");
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=pl0Pm2KQwFT8CtCar4xTsgfa7eDhVRwegR%2BMZxrVvz713LdsGtaBbQHiiYyWbJQ97rsrqLjzf1f%2BW%2FfZly9u7g%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(startDt, "UTF-8")); /*검색할 생성일 범위의 시작*/
        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(endDt, "UTF-8")); /*검색할 생성일 범위의 종료*/
        URL url = new URL(urlBuilder.toString());
        logger.info("startDt:::"+startDt);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        logger.info("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();


        try {
            logger.info("sb:::"+sb.toString());
            xmlParsing(sb.toString());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }finally {
            return coronaDataList;
        }
    }
    public static String getTagValue(String tag, Element element){
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        if(node == null){
            return null;
        }
        return node.getNodeValue();
    }
    public void xmlParsing(String xml) throws ParserConfigurationException, IOException, SAXException {
        if(xml != null){
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputStream is = new ByteArrayInputStream(xml.getBytes());
            Document doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("item");
            for(int temp=0;temp<nList.getLength();temp++){
                Node node = nList.item(temp);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    String decideCnt = getTagValue("decideCnt",element);
                    String clearCnt = getTagValue("clearCnt",element);
                    String examCnt = getTagValue("examCnt",element);
                    String deathCnt = getTagValue("deathCnt",element);
                    String careCnt = getTagValue("careCnt",element);
                    CoronaData coronaData = new CoronaData(decideCnt,clearCnt,examCnt,deathCnt,careCnt);
                    logger.info("coronaData:::"+coronaData);
                    coronaDataList.add(coronaData);
                }
            }
            logger.info("coronaDataList:::"+coronaDataList);

        }
    }

}
