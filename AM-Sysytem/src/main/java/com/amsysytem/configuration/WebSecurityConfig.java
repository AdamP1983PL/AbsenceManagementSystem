package com.amsysytem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("https://amsystemapp.up.railway.app/").hasAnyAuthority("ADMIN", "MANAGER", "USER")
                        .requestMatchers("https://amsystemapp.up.railway.app/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("https://amsystemapp.up.railway.app/manager/**").hasAuthority("MANAGER")
                        .requestMatchers("https://amsystemapp.up.railway.app/user/**").hasAuthority("USER")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("https://amsystemapp.up.railway.app/login")
                        .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(requests ->
                        requests.accessDeniedPage("/amsystemapp.up.railway.app/access-denied"));

        return http.build();
    }
}
