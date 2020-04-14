package com.tjds.jwt.tokenjwt.model;

public class Variables {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60 * 100;
    public static final String SIGNING_KEY = "D3LF05&4T3N45";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTHORITIES_KEY = "scopes";

}
