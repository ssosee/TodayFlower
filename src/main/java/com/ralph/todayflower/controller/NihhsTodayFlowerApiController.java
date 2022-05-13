package com.ralph.todayflower.controller;

import com.ralph.todayflower.service.NihhsTodayFlowerApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.XMLFormatter;

@RestController
@RequestMapping("/TodayFlower")
public class NihhsTodayFlowerApiController {

    @Value("${url}")
    private String url;
    @Value("${serviceKey}")
    private String serviceKey;

    /***
     * 공공 API 데이터 파싱
     * @param month
     * @param day
     * @return
     */
    public Mono<String> getTodayFlower(String month, String day) {

        //입력 월, 일이 없을 경우
        if(month == null || day == null || month == "" || day == "") {
            LocalDateTime currentTime = LocalDateTime.now();
            month = String.format("%d", currentTime.getMonthValue());
            day = String.format("%d", currentTime.getDayOfMonth());
        }

        String finalMonth = month;
        String finalDay = day;

        WebClient webClient = webClient(url);

        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("1390804/NihhsTodayFlowerInfo01/selectTodayFlower01")
                        .queryParam("serviceKey", serviceKey)
                        .queryParam("fMonth", finalMonth)
                        .queryParam("fDay", finalDay)
                        .build())
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(String.class);
    }

    /***
     * 인코딩 메서드
     * @param url
     * @return
     */
    private WebClient webClient(String url) {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(url);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);
        WebClient webClient = WebClient.builder().uriBuilderFactory(factory).baseUrl(url).build();

        return webClient;
    }
}
