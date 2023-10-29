package com.amsysytem.controller;

import com.amsysytem.dto.RegisterDto;
import com.amsysytem.entity.Authority;
import com.amsysytem.entity.User;
import com.amsysytem.repositories.AuthorityRepository;
import com.amsysytem.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

//    todo use @RequiredArgsConstructor annotation

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }


    /* we use RestController because we don't wand to send our credentials by url */

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("There is username in the database with the name: " + registerDto.getUsername(), HttpStatus.BAD_REQUEST);
        } else {
            com.amsysytem.entity.User user = new User();
            user.setUsername(registerDto.getUsername());
            user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

//            todo add logic for adding admin here?

            /* we are creating new User here and in order for us to save his roles (authorities),
            *  we need to set that roles (authorities) */

            Authority authorities = authorityRepository.findByRole("USER").get();
            user.setAuthorities(Collections.singleton(authorities));

            userRepository.save(user);
        }
        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }
}
