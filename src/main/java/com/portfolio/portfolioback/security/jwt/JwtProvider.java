package com.portfolio.portfolioback.security.jwt;


import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import com.portfolio.portfolioback.security.dto.JwtDto;
import com.portfolio.portfolioback.security.entity.UserPrincipal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class JwtProvider {
    
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${jwt.secret}")
    private String secret;
    
    @Value("${jwt.expiration}")
    private int expiration;
    
    public String generateToken(Authentication authentication) {
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        List<String> roles = principal
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }
    
    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody().getSubject();
    }
    
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("malformed token");
        } catch (UnsupportedJwtException e) {
            logger.error("token not supported");
        } catch (ExpiredJwtException e) {
            logger.error("expired token");
        } catch (IllegalArgumentException e) {
            logger.error("empty token");
        } catch (SignatureException e) {
            logger.error("fail in signature");
        }
        return false;
    }
    
    public String refreshToken(JwtDto jwtDto) throws ParseException {
        try {
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(jwtDto.getToken());
        } catch (ExpiredJwtException e) {
            JWT jwt = JWTParser.parse(jwtDto.getToken());
        JWTClaimsSet claims = jwt.getJWTClaimsSet();
        String username = claims.getSubject();
        List<String> roles = (List<String>)claims.getClaim("roles");
        
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + ((expiration * 3) * 168)))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
        }
        return null;
    }
}