package com.job_scheduler;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

@SpringBootApplication
public class JobSchedulerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JobSchedulerApplication.class, args);

//		SecretKey key = Jwts.SIG.HS256.key().build();
//		String secretString = Encoders.BASE64.encode(key.getEncoded());
//		System.out.println(secretString);
	}

}
