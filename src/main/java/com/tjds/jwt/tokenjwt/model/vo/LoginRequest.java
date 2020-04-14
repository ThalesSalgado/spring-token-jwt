package com.tjds.jwt.tokenjwt.model.vo;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;

}
