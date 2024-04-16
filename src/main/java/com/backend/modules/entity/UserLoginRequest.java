package com.backend.modules.entity;

import lombok.Data;

@Data
public class UserLoginRequest {
    private Long uid;
    private String username;
    private String password;
}
