package com.inube.biblioteca_authentication_service.security;

import com.inube.biblioteca_authentication_service.entity.BiblioUsuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    @Setter
    private String secret;
    private Key key;

    @jakarta.annotation.PostConstruct
    public void Init(){
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public Claims getAllClaimsFromToken(String token){
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts
                .parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Boolean isTokenExpired(String token){
        try{
            return this.getAllClaimsFromToken(token).getExpiration().before(new Date());
        }catch (Exception e){
            logger.error(e.getMessage());
            return true;
        }
    }

    public Boolean isInvalid(String token){
        return this.isTokenExpired(token);
    }

    public String generate(BiblioUsuario biblioUsuario){
        Map<String, Object> claims = new HashMap<>();
        claims.put("uuidUsuario", biblioUsuario.getUuidUsuario());
        return doGenerateToken(claims, biblioUsuario);
    }

    private String doGenerateToken(Map<String,Object> claims, BiblioUsuario biblioUsuario){
        long expirationTimeLong = 12 * 60 * 60 * 1000;
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong);
        return Jwts.builder()
                .claims(claims)
                .subject(biblioUsuario.toString())
                .issuedAt(createdDate)
                .expiration(expirationDate)
                .signWith(key)
                .compact();
    }
}
