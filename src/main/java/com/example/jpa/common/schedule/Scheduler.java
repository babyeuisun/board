package com.example.jpa.common.schedule;

import com.example.jpa.logs.service.LogService;
import com.example.jpa.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@RequiredArgsConstructor
public class Scheduler {
    private final LogService logService;
    private final UserService userService;

    @Scheduled(fixedDelay = 1000*60)
    public void deleteLog(){
        log.info("스케줄 실행!!!!!!!!");
        logService.deleteLog();
    }

}
