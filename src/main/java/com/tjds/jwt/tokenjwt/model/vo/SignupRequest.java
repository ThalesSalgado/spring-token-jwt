package com.tjds.jwt.tokenjwt.model.vo;

import lombok.Data;

@Data
public class SignupRequest {

    private String username;
    private String password;
    private String application;

}
