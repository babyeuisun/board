package com.example.jpa.mail.entity;

import com.example.jpa.user.model.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class MailTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String templateId;

    private String title;
    private String contents;
    private String sendEmail;
    private String sendUserName;

    private LocalDateTime regDate;

}
