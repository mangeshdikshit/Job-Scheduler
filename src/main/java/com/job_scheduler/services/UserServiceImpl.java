package com.job_scheduler.services;

import com.job_scheduler.configurations.JwtConfiguration;
import com.job_scheduler.dtos.LoginRequestDto;
import com.job_scheduler.dtos.LoginResponseDto;
import com.job_scheduler.dtos.SignupRequestDto;
import com.job_scheduler.dtos.SignupResponseDto;
import com.job_scheduler.entities.Users;
import com.job_scheduler.models.UserRoles;
import com.job_scheduler.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    public final UserRepository userRepository;
    public final JwtConfiguration jwtConfiguration;

    public UserServiceImpl(UserRepository userRepository, JwtConfiguration jwtConfiguration){
        this.userRepository = userRepository;
        this.jwtConfiguration = jwtConfiguration;
    }

    @Override
    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {

        Users savedUser = userRepository.save(
                new Users(signupRequestDto.getName(),
                signupRequestDto.getEmail(),
                signupRequestDto.getMobileNo(),
                signupRequestDto.getPassword(),
                UserRoles.USER));

        return new SignupResponseDto(jwtConfiguration.generateJwt(savedUser));

    }


    @Override
    public LoginResponseDto logIn(LoginRequestDto loginRequestDto) {

        try{
            Users savedUser = userRepository.findByEmailAndPassword(
                    loginRequestDto.getEmail(),
                    loginRequestDto.getPassword());

            return new LoginResponseDto(jwtConfiguration.generateJwt(savedUser));

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return new LoginResponseDto("null");
        }






    }
}
