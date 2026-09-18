package com.job_scheduler.controllers;

import com.job_scheduler.configurations.JwtConfiguration;
import com.job_scheduler.models.JwtPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    public final JwtConfiguration jwtConfiguration;

    public JobController(JwtConfiguration jwtConfiguration) {
        this.jwtConfiguration = jwtConfiguration;
    }


    @GetMapping("/user/job")
    public ResponseEntity<String> scheduleJob(@RequestParam String jwtToken){
        System.out.println(jwtConfiguration.isJwtExpired(jwtToken));
        JwtPayload jwtPayload = jwtConfiguration.verifyJwt(jwtToken);
        return new ResponseEntity<>("congratulations, you have access!", HttpStatus.OK);
    }
}
