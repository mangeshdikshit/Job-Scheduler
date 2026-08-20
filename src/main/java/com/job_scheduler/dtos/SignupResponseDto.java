package com.job_scheduler.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupResponseDto{
	private String name;
	private String email;
	private String mobileNo;
	private String password;
}
