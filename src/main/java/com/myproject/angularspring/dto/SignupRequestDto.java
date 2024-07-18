package com.myproject.angularspring.dto;

import lombok.Data;

@Data
public class SignupRequestDto {
    private String email;
    private String password;
    private String name;
    private String lastname;
    private String phone;
}