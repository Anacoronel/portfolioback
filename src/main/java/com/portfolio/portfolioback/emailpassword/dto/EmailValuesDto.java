package com.portfolio.portfolioback.emailpassword.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailValuesDto {
    private String mailFrom;
    private String mailTo;
    private String subject;
    private String username;
    private String tokenPassword;
    public String getMailFrom() {
        return mailFrom;
    }
    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }
    public String getMailTo() {
        return mailTo;
    }
    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getTokenPassword() {
        return tokenPassword;
    }
    public void setTokenPassword(String tokenPassword) {
        this.tokenPassword = tokenPassword;
    }
}