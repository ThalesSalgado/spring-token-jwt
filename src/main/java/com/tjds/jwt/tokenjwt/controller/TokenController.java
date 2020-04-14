package com.tjds.jwt.tokenjwt.controller;

import com.tjds.jwt.tokenjwt.jwt.JwtTokenProvider;
import com.tjds.jwt.tokenjwt.model.vo.LoginRequest;
import com.tjds.jwt.tokenjwt.model.vo.LoginResponse;
import com.tjds.jwt.tokenjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
public class TokenController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenUtil;

    @PostMapping(value = "/generate")
    public ResponseEntity<?> register(@RequestBody LoginRequest loginRequest) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new LoginResponse(token));
    }

}
