package com.finance.finance_control_api.Services;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.finance.finance_control_api.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;
    public String generateToken(User user){

       try {
           Algorithm algorithm = Algorithm.HMAC256(secret);
           String token = JWT.create().withIssuer("finance-control-api")
                   .withSubject(user.getEmail())
                   .withExpiresAt(getExpirationTime())
                     .sign(algorithm);
           return token;
       }catch (Exception e){
             throw new RuntimeException("Error while generating token", e);
       }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm).build().verify(token).getSubject();
        }catch (Exception e){
            throw new RuntimeException("Error while validating token", e);
        }
    }

    private Instant getExpirationTime(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
