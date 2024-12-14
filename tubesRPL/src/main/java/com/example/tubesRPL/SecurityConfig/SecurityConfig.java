// package com.example.tubesRPL.SecurityConfig;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// public class SecurityConfig {
// @Bean
// public PasswordEncoder passwordEncoder() {
// return new BCryptPasswordEncoder();
// }

// @Bean
// public UserDetailsService userDetailsService() {
// return new CustomUserDetailsService(); // Implementasi UserDetailsService
// }

// protected void configure(HttpSecurity http) throws Exception {
// http
// .authorizeRequests()
// .antMatchers("/login", "/api/**").permitAll() // Ijinkan akses endpoint API
// .anyRequest().authenticated()
// .and()
// .formLogin()
// .loginPage("/login")
// .defaultSuccessUrl("/")
// .permitAll()
// .and()
// .logout()
// .logoutUrl("/logout")
// .logoutSuccessUrl("/login")
// .permitAll();
// }
// }
