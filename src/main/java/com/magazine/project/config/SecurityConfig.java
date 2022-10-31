package com.magazine.project.config;

import com.magazine.project.security.WebAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userService;
    private final WebAccessDeniedHandler webAccessDeniedHandler;

    @Autowired
    public SecurityConfig(UserDetailsService userService, WebAccessDeniedHandler webAccessDeniedHandler) {
        this.userService = userService;
        this.webAccessDeniedHandler = webAccessDeniedHandler;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/create-magazine").hasRole("ADMIN")
                .antMatchers("/", "/home", "/account/login-form", "/account/registration", "/error", "/access-denied").permitAll()
                .anyRequest().hasAnyRole("USER", "ADMIN")
                .and()
                .exceptionHandling()
                .accessDeniedHandler(webAccessDeniedHandler)
                .and()
                .formLogin().loginPage("/account/login-form")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/account/login-form?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/account/login-form")
                .deleteCookies("JSESSIONID")
                ;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
