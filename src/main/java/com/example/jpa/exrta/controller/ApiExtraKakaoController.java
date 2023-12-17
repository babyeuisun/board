package com.example.jpa.exrta.controller;

import com.example.jpa.common.model.ResponseResult;
import com.example.jpa.exrta.model.AirInput;
import com.example.jpa.exrta.model.KakaoTranslateInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;
import java.util.Collections;



@RequiredArgsConstructor
@RestController

public class ApiExtraKakaoController {
//    curl -v -X GET "https://dapi.kakao.com/v2/search/web" \
//            --data-urlencode "query=이효리" \
//            -H "Authorization: KakaoAK ${REST_API_KEY}"

    @GetMapping("/api/extra/kakao/translate")
    public ResponseEntity<?> translate(@RequestBody KakaoTranslateInput kakaoTranslateInput){

        String restApiKey = "11bda061ee85bedd0e6ca1118fc863ce";
        String url = "https://dapi.kakao.com/v2/search/web";

        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String,String> parameter = new LinkedMultiValueMap<>();
        parameter.add("data" , "urlencode");
        parameter.add("query", kakaoTranslateInput.getText());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization","KakaoAK"+restApiKey);

        HttpEntity formEntity = new HttpEntity<>(parameter,headers);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);

        return ResponseResult.success(responseEntity.getBody());

    }



}



















