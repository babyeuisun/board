package com.example.jpa.logs.service;

import com.example.jpa.board.model.ServiceResult;
import com.example.jpa.user.entity.User;
import com.example.jpa.user.model.UserLogCount;
import com.example.jpa.user.model.UserLogin;
import com.example.jpa.user.model.UserNoticeCount;
import com.example.jpa.user.model.UserSummary;

import java.util.List;

public interface LogService {
    void add(String text);

    void deleteLog();
}
