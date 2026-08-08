package com.job_scheduler.controllers;

import com.job_scheduler.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job_scheduler.dtos.SignupRequestDto;
import com.job_scheduler.dtos.SignupResponseDto;

@RestController
public class UserController{

	public final UserService userService;

	public UserController(UserService userService){
		this.userService = userService;
	}

	@PostMapping("/signup")
	public SignupResponseDto signUp(SignupRequestDto signupRequestDto) {
		return userService.signup(signupRequestDto);
	}
}