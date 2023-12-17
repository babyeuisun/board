package com.example.jpa.user.controller;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.jpa.board.model.ServiceResult;
import com.example.jpa.common.exception.BizExeption;
import com.example.jpa.common.model.ResponseResult;
import com.example.jpa.notice.model.ResponseError;
import com.example.jpa.user.entity.User;
import com.example.jpa.user.model.UserLogin;
import com.example.jpa.user.model.UserLoginToken;
import com.example.jpa.user.service.UserService;
import com.example.jpa.util.JWTUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Slf4j

//@RequiredArgsConstructor
//@RestController
//public class ApiLoginController {
//    private final UserService userService;
//
//    @PostMapping("/api/login")
//    public ResponseEntity<?> login(@RequestBody @Valid UserLogin userLogin, Errors errors){
//        if(errors.hasErrors()){
//            return ResponseResult.fail("입력값이 정확하지 않아", ResponseError.of(errors.getAllErrors()));
//        }
//        User user = null;
//        try {
//             user = userService.login(userLogin);
//        }catch (BizExeption e){
//            return ResponseResult.fail(e.getMessage());
//        }
//
//        UserLoginToken userLoginToken = JWTUtils.createToken(user);
//        if(userLoginToken == null){
//            return ResponseResult.fail("생성 실패");
//        }
//        return ResponseResult.success(userLoginToken);
//
//    }
    @RequiredArgsConstructor
    @RestController
    public class ApiLoginController {
        private final UserService userService;

        @PostMapping("/api/login")
        public ResponseEntity<?> login(@RequestBody @Valid UserLogin userLogin, Errors errors){
            log.info("로그인 함수 !!");

            if(errors.hasErrors()){
                return ResponseResult.fail("입력값이 정확하지 않아", ResponseError.of(errors.getAllErrors()));
            }
            User user = null;
            try {
                user = userService.login(userLogin);
            }catch (BizExeption e){
                log.info("로그린에러" +e.getMessage());
                return ResponseResult.fail(e.getMessage());
            }


            UserLoginToken userLoginToken = JWTUtils.createToken(user);
            if(userLoginToken == null){
                log.info("jwt생성에러");
                return ResponseResult.fail("생성 실패");
            }
            return ResponseResult.success(userLoginToken);

        }



    }