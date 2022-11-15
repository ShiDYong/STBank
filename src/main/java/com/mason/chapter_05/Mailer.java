package com.mason.chapter_05;

import lombok.Data;

/**
 * @author yongshi
 * @date 2022/11/13 17:08
 * @Description 业务领域类：邮箱
 */
@Data
public class Mailer {

    private String username;
    private String password;
    private String email;

    public Mailer(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public static void sendEmail(String s, String s1) {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Mailer{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
