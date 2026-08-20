package com.job_scheduler.dtos;

import jakarta.validation.constraints.Email;
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
public class LoginRequestDto {

    @NotNull(message = "Email can't be Null!")
    @Email(message = "Email has to be Valid!")
    private String email;

    @NotNull(message = "Password can't be Null!")
    @Size(min = 8)
    private String password;
}
