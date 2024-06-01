package com.example.hackaton_gg.Auth.Dto;

import lombok.Data;

@Data
public class AuthRegisterRequest {
    String firstName;
    String lastName;
    String email;
    String password;
    Boolean isAdmin;
    //xd
}