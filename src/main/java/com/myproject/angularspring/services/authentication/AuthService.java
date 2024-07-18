package com.myproject.angularspring.services.authentication;

import com.myproject.angularspring.dto.SignupRequestDto;
import com.myproject.angularspring.dto.UserDto;

public interface AuthService {
    UserDto signUpClient(SignupRequestDto signupRequestDto);
    Boolean presentByEmail(String email);
    UserDto signUpCompany(SignupRequestDto signupRequestDto);
}
