package com.backend.modules.entity;

import lombok.Data;

@Data
public class UserLoginRequest {
    private Long uId;
    private String username;
    private String password;
}
