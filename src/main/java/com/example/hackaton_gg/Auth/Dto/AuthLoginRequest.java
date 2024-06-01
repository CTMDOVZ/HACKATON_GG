package com.example.hackaton_gg.Auth.Dto;

import lombok.Data;

@Data
public class AuthLoginRequest {
    public String email;
    public String password;
}