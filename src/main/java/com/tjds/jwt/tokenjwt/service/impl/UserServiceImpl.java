package com.tjds.jwt.tokenjwt.service.impl;

import com.tjds.jwt.tokenjwt.exception.ObjectNotFoundException;
import com.tjds.jwt.tokenjwt.model.User;
import com.tjds.jwt.tokenjwt.model.vo.SignupRequest;
import com.tjds.jwt.tokenjwt.repository.UserRepository;
import com.tjds.jwt.tokenjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository repository;

    private final BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = repository.findByUsername(username);

        if (userOpt.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username.");
        }
        User user = userOpt.get();

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        if (user.getRoles().isEmpty()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_DEFAULT"));
        } else {
            user.getRoles().forEach(role -> {
                //authorities.add(new SimpleGrantedAuthority(role.getName()));
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
            });
        }

        return authorities;
        //return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(list::add);

        return list;
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public User findOne(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException(HttpStatus.BAD_REQUEST, "User not found"));
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public User save(SignupRequest signupRequest) {
        User newUser = new User();
        newUser.setUsername(signupRequest.getUsername());
        newUser.setPassword(bcryptEncoder.encode(signupRequest.getPassword()));
        newUser.setApplication(signupRequest.getApplication());
        return repository.save(newUser);
    }

}
