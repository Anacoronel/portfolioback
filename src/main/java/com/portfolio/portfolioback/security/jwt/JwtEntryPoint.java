package com.portfolio.portfolioback.security.jwt;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {
    
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        logger.error("Fail in commence method", authException.getMessage()) ;
        if(authException instanceof BadCredentialsException) {
            res.setContentType(MediaType.APPLICATION_JSON_VALUE);
            Result invalidUserNameOrPassword = ControllerUtils.buildErrorResult(101, "Incorrect account or password");
            res.getOutputStream().write(new ObjectMapper()
                    .writeValueAsBytes(invalidUserNameOrPassword));
        } else {
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "unauthorized");
    }
}