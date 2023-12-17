package com.example.jpa.exrta.controller;

import com.example.jpa.common.model.ResponseResult;
import com.example.jpa.common.properties.NaverAppProperties;
import com.example.jpa.exrta.model.KakaoTranslateInput;
import com.example.jpa.exrta.model.NaverTranslateInput;
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


@RequiredArgsConstructor
@RestController

public class ApiExtraNaverController {
    private final NaverAppProperties naverAppProperties;

    @GetMapping("/api/extra/naver/translate")
    public ResponseEntity<?> translate(@RequestBody NaverTranslateInput naverTranslateInput){


        String clientId = naverAppProperties.getClientId();
        String clientKey = naverAppProperties.getClientSecret();
        String url = "https://openapi.naver.com/v1/papago/n2mt";

        RestTemplate restTemplate  = new RestTemplate();
        MultiValueMap<String ,String> parameter = new LinkedMultiValueMap<>();
        parameter.add("source","ko");
        parameter.add("target","en");
        parameter.add("text", naverTranslateInput.getText());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("X-Naver-Client-Id",clientId);
        headers.add("X-Naver-Client-Secret",clientKey);

        HttpEntity formEntity = new HttpEntity<>(parameter,headers);
        ResponseEntity<String> responseEntity =  restTemplate.postForEntity(url,formEntity,String.class);

        return ResponseResult.success(responseEntity.getBody());
    }

}



















