package com.tjds.jwt.tokenjwt.jwt;

import com.tjds.jwt.tokenjwt.service.LDAPService;
import com.tjds.jwt.tokenjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthenticationManager {

    private final UserDetailsService userService;

    private final LDAPService ldapService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails ud;
        // Realizar a validacao do usuario aqui: consulta AD e monta as credenciais
        try {
            ud = userService.loadUserByUsername(username);

            //new SimpleGrantedAuthority("ROLE_" + role.getName())
            /*Collection<SimpleGrantedAuthority> simpleGrantedAuthorityList = ud.getAuthorities().stream()
                    .map(a -> new SimpleGrantedAuthority("ROLE_" + a.getAuthority().toString()))
                    .collect(Collectors.toCollection());
            authentication.getAuthorities().addAll(simpleGrantedAuthorityList);*/

            // ldapService.consultAD(username, password);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return new UsernamePasswordAuthenticationToken(
                authentication.getName(),
                authentication.getCredentials().toString(),
                ud.getAuthorities().stream()
                        .map(a -> new SimpleGrantedAuthority(a.getAuthority()))
                        .collect(Collectors.toList()));
    }

}
