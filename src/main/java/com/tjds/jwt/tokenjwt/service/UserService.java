package com.tjds.jwt.tokenjwt.service;

import com.tjds.jwt.tokenjwt.model.User;
import com.tjds.jwt.tokenjwt.model.vo.SignupRequest;

import java.util.List;

public interface UserService {

    User save(SignupRequest signupRequest);

    List<User> findAll();

    void delete(long id);

    User findOne(String username);

    User findById(Long id);

}
