package com.example.appjwtrealemailauditing.security;

import com.example.appjwtrealemailauditing.entity.Role;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Component
public class JwtProvider {
    private static final long expireTime=1000*60*60*24;
    private static final String secretKey="maxfiySo'z";
    public String generateToken(String username, Set<Role> roles){
        Date date = new Date(System.currentTimeMillis() + expireTime);

        String token= Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(date)
                .claim("roles",roles)
                .signWith(SignatureAlgorithm.HS512,secretKey)
                .compact();
        return token;


    }
}
