package com.myproject.angularspring.dto;

import com.myproject.angularspring.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private String phone;
    private UserRole role;
    public UserDto(long id, String email, String name, String lastname, String phone, UserRole role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.role = role;
    }
}
