package com.amsysytem.security;

import com.amsysytem.entity.Authority;
import com.amsysytem.entity.User;
import com.amsysytem.repositories.AuthorityRepository;
import com.amsysytem.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserDataLoader implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private void loadSecurityData() {
        Authority admin = authorityRepository.save(Authority.builder().role("ROLE_ADMIN").build());
        Authority userRole = authorityRepository.save(Authority.builder().role("ROLE_USER").build());
        Authority manager = authorityRepository.save(Authority.builder().role("ROLE_MANAGER").build());

        userRepository.save(User.builder()
                .username("userRole")
                .password(passwordEncoder.encode("userRole"))
                .authorities((Set<Authority>) admin)
                .build());

        userRepository.save(User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .authorities((Set<Authority>) userRole)
                .build());

        userRepository.save(User.builder()
                .username("manager")
                .password(passwordEncoder.encode("manager"))
                .authorities((Set<Authority>) manager)
                .build());

        log.debug("Users loaded: " + userRepository.count());
    }


//    public enum EmployeeRole {
//        ADMIN("Admin"),
//        USER("User"),
//        MANAGER("Manager");


    @Override
    public void run(String... args) throws Exception {
        if (authorityRepository.count() == 0) {
            loadSecurityData();
        }
    }
}
