package com.job_scheduler.configurations;

import com.job_scheduler.entities.Users;
import com.job_scheduler.models.JwtPayload;
import com.job_scheduler.models.UserRoles;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtConfiguration {

    @Value("${jwt.secret}")
    private String signingKey;

    public SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.signingKey));
    }

    public String generateJwt(Users user){
        return Jwts.builder()
                .header()
                .add("typ","JWT")
                .and()

                .claim("userId",user.getUserId() )
                .claim("userRole", user.getUserRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 60000))
                .signWith(getSigningKey())
                .compact();
    }

    public JwtPayload verifyJwt(String jwtToken){
        int userId = (int) Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(jwtToken)
                .getPayload().get("userId");

        String userRole = (String) Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(jwtToken)
                .getPayload().get("userRole");

        return new JwtPayload(userId, UserRoles.valueOf(userRole));
    }

    public boolean isJwtExpired(String jwtToken){
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(jwtToken)
                .getPayload().getExpiration().before(new Date());
    }
}