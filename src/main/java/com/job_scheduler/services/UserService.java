package com.job_scheduler.services;

import com.job_scheduler.dtos.SignupRequestDto;
import com.job_scheduler.dtos.SignupResponseDto;

public interface UserService {
    public SignupResponseDto signup(SignupRequestDto signupRequestDto);

}
