package com.ralph.todayflower.externalapi;

import com.ralph.todayflower.controller.NihhsTodayFlowerApiController;
import com.ralph.todayflower.dto.NihhsTodayFlowerApiDto;
import com.ralph.todayflower.service.NihhsTodayFlowerApiService;
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
import java.io.StringReader;

public class testmain {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        NihhsTodayFlowerApiController nihhsTodayFlowerApiController = new NihhsTodayFlowerApiController();
        NihhsTodayFlowerApiService nihhsTodayFlowerApiService = new NihhsTodayFlowerApiService(nihhsTodayFlowerApiController);
        //NihhsTodayFlowerApiDto nihhsTodayFlowerApiDto = nihhsTodayFlowerApiService.getTodayFlower();
    }
}
