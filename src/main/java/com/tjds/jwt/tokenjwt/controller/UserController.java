package com.tjds.jwt.tokenjwt.controller;

import com.tjds.jwt.tokenjwt.model.User;
import com.tjds.jwt.tokenjwt.model.vo.SignupRequest;
import com.tjds.jwt.tokenjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<User> listUser(){
        return userService.findAll();
    }

    //@Secured("ROLE_USER")
    @PreAuthorize("hasRole('USER')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping(value = "/{id}")
    public User getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }


    @PostMapping(value="/signup")
    public User saveUser(@RequestBody SignupRequest signupRequest){
        return userService.save(signupRequest);
    }

}
