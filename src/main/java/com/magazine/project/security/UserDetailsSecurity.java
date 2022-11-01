package com.magazine.project.security;

import com.magazine.project.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Slf4j
public class UserDetailsSecurity implements UserDetails {
    private final User user;

    public UserDetailsSecurity(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("method getAuthorities");
        String role = user.getRole();
        log.info("user role is {}", role);
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        log.info("method getPassword");
        log.info("passwort = {}", this.user.getPassword());
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        log.info("method getUsername");
        log.info("username = {}", this.user.getUserName());
        return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return this.user;
    }
}
