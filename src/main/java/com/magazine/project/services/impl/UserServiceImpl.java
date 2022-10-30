package com.magazine.project.services.impl;

import com.magazine.project.entity.User;
import com.magazine.project.repositories.UserRepository;
import com.magazine.project.security.UserDetailsSecurity;
import com.magazine.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean add(User user) {
        User saved = userRepository.save(user);
        return saved.getEmail().equals(user.getEmail());
    }

    @Override
    public User getById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        try {
            return optionalUser.orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
    }

    @Override
    public User getByUserName(String userName) {
        Optional<User> optionalUser = userRepository.getUserByUserName(userName);
        try {
            return optionalUser.orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("User with username " + userName + " not found");
        }
    }

    @Override
    public User getByEmail(String email) {
        Optional<User> optionalUser = userRepository.getUserByEmail(email);
        try {
            return optionalUser.orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("User with email " + email + " not found");
        }
    }

    @Override
    public boolean update(User user) {
        return add(user);
    }

    @Override
    public boolean delete(long id) {
        userRepository.delete(getById(id));
        return userRepository.findById(id).isEmpty();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.getUserByUserName(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }
        return new UserDetailsSecurity(optionalUser.get());
    }
}
