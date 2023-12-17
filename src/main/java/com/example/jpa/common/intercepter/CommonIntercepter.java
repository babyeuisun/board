package com.example.jpa.common.intercepter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.example.jpa.common.exception.AuthFailException;
import com.example.jpa.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Slf4j
public class CommonIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        log.info("########3");
        log.info("인터셉트");
        log.info("asdasda");
        log.info(request.getMethod());
        log.info(request.getRequestURI());

        if(!validJWT(request)){
            throw new AuthFailException("인증정보 없어");

        }
        return true;
    }

    private boolean validJWT(HttpServletRequest request) {
        String token = request.getHeader("F-TOKEN");
        String email = "";
        try {
            email = JWTUtils.getIssuer(token);
        }catch (JWTVerificationException e ){
            return false;
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
