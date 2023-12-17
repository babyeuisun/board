package com.example.jpa.exrta.controller;

import com.example.jpa.board.entity.BoardBadReport;
import com.example.jpa.board.service.BoardService;
import com.example.jpa.common.model.ResponseResult;
import com.example.jpa.exrta.model.AirInput;
import com.sun.jndi.toolkit.url.Uri;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


//@RequiredArgsConstructor
//@RestController
//public class ApiExtraController {
//
//    @GetMapping("api/extra/pharmacy")
//    public String pharmacy(){
//        String apiKey = "9cnQiyBmAKY5r86SCeMceLunUBsrSIXO9T5J7AWC9vHUNHXM0fDKLiZib8XhQy2lhPrHuSdOB%2FKNJzj1sA1O4A%3D%3D";
//        String url = "https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown?serviceKey=%s&pageNo=1&numOfRows=10";
//        String apiResult = "";
//        try {
//            URI uri = new URI(String.format(url,apiKey));
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//            String result = restTemplate.getForObject(uri,String.class);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return apiResult;
//    }
@RequiredArgsConstructor
@RestController
public class ApiExtraController {

    @GetMapping("/api/extra/air")
    public String air(@RequestBody AirInput airInput){
        String apiKey = "9cnQiyBmAKY5r86SCeMceLunUBsrSIXO9T5J7AWC9vHUNHXM0fDKLiZib8XhQy2lhPrHuSdOB%2FKNJzj1sA1O4A%3D%3D";
        String url = "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=%s&pageNo=1&numOfRows=10&sidoName=%EC%84%9C%EC%9A%B8&ver=1.0";
        String apiResult = "";
        try {
            URI uri = new URI(String.format(url,apiKey, URLEncoder.encode(airInput.getSearchSido(),"UTF-8")));
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            String result = restTemplate.getForObject(uri,String.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return apiResult;
    }


}



















