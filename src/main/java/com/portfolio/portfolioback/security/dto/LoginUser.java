package com.portfolio.portfolioback.security.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class LoginUser {
    @NotBlank
    private String username;
    @NotBlank
    private String password;


}