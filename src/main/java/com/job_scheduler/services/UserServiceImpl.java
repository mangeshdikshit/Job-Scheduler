package com.job_scheduler.services;

import com.job_scheduler.dtos.SignupRequestDto;
import com.job_scheduler.dtos.SignupResponseDto;
import com.job_scheduler.entities.Users;
import com.job_scheduler.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    public final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {

        Users currentUser = new Users(signupRequestDto.getName(), signupRequestDto.getEmail(), signupRequestDto.getMobileNo(), signupRequestDto.getPassword());
        Users savedUser = userRepository.save(currentUser);
        return new SignupResponseDto(savedUser.getName(),savedUser.getEmail(),savedUser.getMobileNo(),savedUser.getPassword());

    }
}
