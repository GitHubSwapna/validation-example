package com.spring.boot.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception
    {
        System.out.println("securityFilterChain Created");
        return http.authorizeHttpRequests(
                req -> {
                    req.requestMatchers("/user").hasAnyRole("USER");
                    req.requestMatchers("/admin").hasRole("ADMIN");
                    req.requestMatchers("/error").permitAll();
                    req.anyRequest().authenticated();
                })
                .formLogin(form -> form.permitAll())
                .logout(out -> out.permitAll())
                .build();

    }
    @Bean
    public UserDetailsService createUsers()
    {
        System.out.println("UserDetailsService Created");

        UserDetails ud1 =
        User.builder()
                .username("swapna")
                .password(passwordencoder().encode("user"))
                .roles("USER")
                .build();
        UserDetails ud2 =
                User.builder()
                        .username("akhila")
                        .password(passwordencoder().encode("admin"))
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(ud1,ud2);
    }

    @Bean
    public PasswordEncoder passwordencoder() {
       return new BCryptPasswordEncoder();
    }


}
