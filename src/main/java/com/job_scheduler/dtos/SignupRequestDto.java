package com.job_scheduler.dtos;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequestDto{

	@NotNull(message = "Name can't be Null!")
	@NotBlank(message = "Names can't be Blank!")
	private String name;

	@NotNull(message = "Email can't be Null!")
	@Email(message = "Email has to be Valid!")
	private String email;

	@NotNull(message = "Mobile Number can't be Null!")
	@Size(max = 10, min = 10)
	private String mobileNo;

	@NotNull(message = "Password can't be Null")
	@Size(min = 8)
	private String password;
}