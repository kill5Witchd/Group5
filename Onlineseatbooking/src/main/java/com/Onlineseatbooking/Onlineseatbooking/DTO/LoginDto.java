package com.Onlineseatbooking.Onlineseatbooking.DTO;

import lombok.Data;

@Data
public class LoginDto {
    private String usernameOrEmail;
    private String password;

   public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

   public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public void setPassword(String password) {
        this.password = password;
           }

    public String getPassword() {
        return password;
        }


}
