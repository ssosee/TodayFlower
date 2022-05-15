package com.ralph.todayflower.callapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Component
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
    public Mono<String> getTodayFlowerByDate(String month, String day) {

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
                .accept(MediaType.APPLICATION_ATOM_XML)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getTodayFlowerListByFlowerLang(@NotNull String flowerLang) {

        WebClient webClient = webClient(url);

        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("http://apis.data.go.kr/1390804/NihhsTodayFlowerInfo01/selectTodayFlowerView01")
                        .queryParam("searchType", SearchType.flowLang.getValue())
                        .queryParam("searchWord", flowerLang)
                        .queryParam("numOfRows", 366)
                        .queryParam("serviceKey", serviceKey)
                        .build())
                .accept(MediaType.APPLICATION_ATOM_XML)
                .retrieve()
                .bodyToMono(String.class);

    }

    public Mono<String> getTodayFlowerByDataNo(int dataNo) {
        WebClient webClient = webClient(url);

        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("http://apis.data.go.kr/1390804/NihhsTodayFlowerInfo01/selectTodayFlowerView01")
                        .queryParam("dataNo", dataNo)
                        .queryParam("serviceKey", serviceKey)
                        .build())
                .accept(MediaType.APPLICATION_ATOM_XML)
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
