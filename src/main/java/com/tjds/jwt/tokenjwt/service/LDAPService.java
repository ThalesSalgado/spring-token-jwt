package com.tjds.jwt.tokenjwt.service;

public interface LDAPService {

    Boolean consultAD(String username, String password);

}
