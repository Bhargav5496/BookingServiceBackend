package com.myproject.angularspring.services.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.angularspring.dto.SignupRequestDto;
import com.myproject.angularspring.dto.UserDto;
import com.myproject.angularspring.entities.User;
import com.myproject.angularspring.enums.UserRole;
import com.myproject.angularspring.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService{
    
    @Autowired
    private UserRepository userRepository;

    public UserDto signUpClient(SignupRequestDto signupRequestDto){
        User user = new User();

        user.setEmail(signupRequestDto.getEmail());
        user.setLastname(signupRequestDto.getLastname());
        user.setName(signupRequestDto.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDto.getPassword()));
        user.setPhone(signupRequestDto.getPhone());
        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDto();
    }

    public Boolean presentByEmail(String email) {
        return userRepository.findFirstByEmail(email) != null;
    }

    public UserDto signUpCompany(SignupRequestDto signupRequestDto){
        User user = new User();

        user.setEmail(signupRequestDto.getEmail());
        user.setName(signupRequestDto.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDto.getPassword()));
        user.setPhone(signupRequestDto.getPhone());
        user.setRole(UserRole.COMPANY);

        return userRepository.save(user).getDto();
    }

}
