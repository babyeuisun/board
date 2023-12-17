package com.example.jpa.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Normalized;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPasswordResetInput {

    @Email(message = "이메일 형식이 아님")
    @NotBlank(message = "이메일은 필수 입력임")
    private String email;

    @NotBlank(message = "이름은 필수야")
    private String userName;
}
