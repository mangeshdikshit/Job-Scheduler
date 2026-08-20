package com.job_scheduler.controllers;

import com.job_scheduler.dtos.LoginRequestDto;
import com.job_scheduler.dtos.LoginResponseDto;
import com.job_scheduler.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<SignupResponseDto> signUp(@Valid @RequestBody SignupRequestDto signupRequestDto) {
		return new ResponseEntity<>( userService.signup(signupRequestDto), HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> logIn( @Valid @RequestBody LoginRequestDto loginRequestDto){

		LoginResponseDto dto = userService.logIn(loginRequestDto);
		if(dto.getEmail().equals("null")){
			return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
		}
		else{
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
	}
}