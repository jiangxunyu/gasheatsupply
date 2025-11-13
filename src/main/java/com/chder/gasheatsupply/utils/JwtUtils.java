package com.chder.gasheatsupply.utils;

import com.chder.gasheatsupply.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    @Autowired
    private JwtConfig jwtConfig;

    /**
     * 生成Token
     * @param username
     * @return
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1小时
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret())
                .compact();
    }

    /**
     * 解析Token（异常处理优化）
     * @param token
     * @return
     * @throws ExpiredJwtException
     */
    public Claims parseToken(String token) throws Exception{
        return Jwts.parser()
                .setSigningKey(jwtConfig.getSecret())
                .parseClaimsJws(token)
                .getBody();
    }
}

