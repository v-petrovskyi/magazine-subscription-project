package com.magazine.project.services.impl;

import com.magazine.project.entity.User;
import com.magazine.project.repositories.UserRepository;
import com.magazine.project.security.UserDetailsSecurity;
import com.magazine.project.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean add(User user) {
        log.info("method add");
        log.info(user.toString());
        User saved = userRepository.save(user);
        return saved.getEmail().equals(user.getEmail());
    }

    @Override
    public User getById(long id) {
        log.info("method getById(long id), id = {}", id);
        Optional<User> optionalUser = userRepository.findById(id);
        try {
            return optionalUser.orElseThrow();
        } catch (NoSuchElementException e) {
            log.error("User with id " + id + " not found");
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
    }

    @Override
    public User getByUserName(String userName) {
        log.info("method getByUserName(String userName), userName = {}", userName);
        Optional<User> optionalUser = userRepository.getUserByUserName(userName);
        try {
            return optionalUser.orElseThrow();
        } catch (NoSuchElementException e) {
            log.error("User with username " + userName + " not found");
            throw new EntityNotFoundException("User with username " + userName + " not found");
        }
    }

    @Override
    public User getByEmail(String email) {
        log.info("method getByEmail(String email), email = {}", email);
        Optional<User> optionalUser = userRepository.getUserByEmail(email);
        try {
            return optionalUser.orElseThrow();
        } catch (NoSuchElementException e) {
            log.error("User with email " + email + " not found");
            throw new EntityNotFoundException("User with email " + email + " not found");
        }
    }

    @Override
    public boolean update(User user) {
        log.info("method update(User user)");
        log.info(user.toString());
        return add(user);
    }

    @Override
    public boolean delete(long id) {
        log.info("method delete(long id), id = {}", id);
        userRepository.delete(getById(id));
        return userRepository.findById(id).isEmpty();
    }

    @Override // method for security from UserDetailsService
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("method loadUserByUsername(String username), username = {}", username);
        Optional<User> optionalUser = userRepository.getUserByUserName(username);
        if (optionalUser.isEmpty()) {
            log.error("User not found!");
            throw new UsernameNotFoundException("User not found!");
        }
        return new UserDetailsSecurity(optionalUser.get());
    }
}
