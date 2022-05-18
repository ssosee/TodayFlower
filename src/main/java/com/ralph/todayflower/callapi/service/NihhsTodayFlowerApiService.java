package com.ralph.todayflower.callapi.service;

import com.ralph.todayflower.callapi.controller.NihhsTodayFlowerApiController;
import com.ralph.todayflower.callapi.dto.NihhsApiResponseDetails;
import com.ralph.todayflower.callapi.dto.NihhsTodayFlowerApiDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class NihhsTodayFlowerApiService {

    private final NihhsTodayFlowerApiController nihhsTodayFlowerApiController;
    private Map<String, String> nihhsTodayFlowerApiMap = new ConcurrentHashMap<>();

    private String month;
    private String day;
    private String flowerLang;

    public void changeTodayFlowerDate(String month, String day) {
        this.month = month;
        this.day = day;
    }

    public void changeTodayFlowerLang(String flowerLang) {
        this.flowerLang = flowerLang;
    }

    public NihhsTodayFlowerApiDto getTodayFlowerByDate() {

        Map<String, String> nihhsTodayFlowerApiMap = new ConcurrentHashMap<>();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document =
                    db.parse(new InputSource(new StringReader(nihhsTodayFlowerApiController.getTodayFlowerByDate(month, day).block())));
            document.getDocumentElement().normalize();

            NodeList nList = document.getElementsByTagName("result");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (((Node) nNode).getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    saveDataByElement(nihhsTodayFlowerApiMap, eElement);
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        NihhsTodayFlowerApiDto nihhsTodayFlowerApiDto =
                NihhsTodayFlowerApiDto.builder()
                        .dataNo(Integer.parseInt(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.dataNo.toString())))
                        .month(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fMonth.toString()))
                        .day(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fDay.toString()))
                        .name(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.flowNm.toString()))
                        .lang(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.flowLang.toString()))
                        .scientificName(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fSctNm.toString()))
                        .englishName(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fEngNm.toString()))
                        .content(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fContent.toString()))
                        .use(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fUse.toString()))
                        .grow(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fGrow.toString()))
                        .nativePlace(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fType.toString()))
                        .fileName1(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fileName1.toString()))
                        .fileName2(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fileName2.toString()))
                        .fileName3(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fileName3.toString()))
                        .imgUrl1(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.imgUrl1.toString()))
                        .imgUrl2(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.imgUrl2.toString()))
                        .imgUrl3(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.imgUrl3.toString()))
                        .publishOrg(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.publishOrg.toString()))
                        .build();

        return nihhsTodayFlowerApiDto;
    }

    public NihhsTodayFlowerApiDto getTodayFlowerByFlowerLang() {

        Map<String, String> nihhsTodayFlowerApiMap = new ConcurrentHashMap<>();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document =
                    db.parse(new InputSource(new StringReader(nihhsTodayFlowerApiController.getTodayFlowerListByFlowerLang(flowerLang).block())));
            document.getDocumentElement().normalize();

            NodeList nList = document.getElementsByTagName("result");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (((Node) nNode).getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    saveDataByElement(nihhsTodayFlowerApiMap, eElement);
                    System.out.println("test = "+ eElement.getElementsByTagName("dataNo").item(temp).getTextContent());
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        NihhsTodayFlowerApiDto nihhsTodayFlowerApiDto =
                NihhsTodayFlowerApiDto.builder()
//                        .dataNo(Integer.parseInt(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.dataNo.toString())))
//                        .month(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fMonth.toString()))
//                        .day(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fDay.toString()))
//                        .name(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.flowNm.toString()))
//                        .lang(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.flowLang.toString()))
//                        .scientificName(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fSctNm.toString()))
//                        .englishName(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fEngNm.toString()))
//                        .content(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fContent.toString()))
//                        .use(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fUse.toString()))
//                        .grow(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fGrow.toString()))
//                        .nativePlace(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fType.toString()))
//                        .fileName1(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fileName1.toString()))
//                        .fileName2(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fileName2.toString()))
//                        .fileName3(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.fileName3.toString()))
//                        .imgUrl1(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.imgUrl1.toString()))
//                        .imgUrl2(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.imgUrl2.toString()))
//                        .imgUrl3(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.imgUrl3.toString()))
//                        .publishOrg(nihhsTodayFlowerApiMap.get(NihhsApiResponseDetails.publishOrg.toString()))
                        .build();

        return nihhsTodayFlowerApiDto;
    }

    private void saveDataByElement(Map<String, String> nihhsTodayFlowerApiMap, Element eElement) {
        nihhsTodayFlowerApiMap.put("dataNo", eElement.getElementsByTagName("dataNo").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("fMonth", eElement.getElementsByTagName("fMonth").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("fDay", eElement.getElementsByTagName("fDay").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("flowNm", eElement.getElementsByTagName("flowNm").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("fSctNm", eElement.getElementsByTagName("fSctNm").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("fEngNm", eElement.getElementsByTagName("fEngNm").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("flowLang", eElement.getElementsByTagName("flowLang").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("fContent", eElement.getElementsByTagName("fContent").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("fUse", eElement.getElementsByTagName("fUse").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("fGrow", eElement.getElementsByTagName("fGrow").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("fType", eElement.getElementsByTagName("fType").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("fileName1", eElement.getElementsByTagName("fileName1").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("fileName2", eElement.getElementsByTagName("fileName2").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("fileName3", eElement.getElementsByTagName("fileName3").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("imgUrl1", eElement.getElementsByTagName("imgUrl1").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("imgUrl2", eElement.getElementsByTagName("imgUrl2").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("imgUrl3", eElement.getElementsByTagName("imgUrl3").item(0).getTextContent());
        nihhsTodayFlowerApiMap.put("publishOrg", eElement.getElementsByTagName("publishOrg").item(0).getTextContent());
    }

}
