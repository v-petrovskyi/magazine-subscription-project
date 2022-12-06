package com.magazine.project.services.impl;

import com.magazine.project.entity.User;
import com.magazine.project.repositories.UserRepository;
import com.magazine.project.security.UserDetailsSecurity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    private final UserServiceImpl userService;

    UserServiceImplTest() {
        MockitoAnnotations.openMocks(this);
        this.userService = new UserServiceImpl(userRepository);
    }


    @Test
    void add_Should_ReturnTrue() {
        User user = new User(1, "user", "user@email.com", "qwerty", "USER", null, null);
        given(userRepository.save(user)).willReturn(user);

        boolean actual = userService.add(user);
        assertTrue(actual);
    }

    @Test
    void getById_Should_ReturnCorrectUser() {
        long id = 1;
        User expected = new User(1, "user", "user@email.com", "qwerty", "USER", null, null);

        given(userRepository.findById(id)).willReturn(Optional.of(expected));

        User actual = userService.getById(id);
        assertEquals(expected, actual);
    }

    @Test
    void getById_Should_TrowException() {
        long id = 1;
        String expectedMessage = "User with id " + id + " not found";

        given(userRepository.findById(id)).willReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> userService.getById(id), expectedMessage);
    }

    @Test
    void getByUserName_Should_ReturnCorrectUser() {
        String userName = "user";
        User expected = new User(1, "user", "user@email.com", "qwerty", "USER", null, null);

        given(userRepository.getUserByUserName(userName)).willReturn(Optional.of(expected));

        User actual = userService.getByUserName(userName);
        assertEquals(expected, actual);
    }

    @Test
    void getByUserName_Should_TrowException_When_UserIsNull() {
        String userName = "user";
        String expectedMessage = "User with username " + userName + " not found";

        given(userRepository.getUserByUserName(userName)).willReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, ()-> userService.getByUserName(userName), expectedMessage);
    }


    @Test
    void getByEmail_Should_ReturnCorrectUser() {
        String userEmail = "user@email.com";
        User expected = new User(1, "user", "user@email.com", "qwerty", "USER", null, null);

        given(userRepository.getUserByEmail(userEmail)).willReturn(Optional.of(expected));

        User actual = userService.getByEmail(userEmail);
        assertEquals(expected, actual);
    }

    @Test
    void update() {
    }

    @Test
    void delete_Should_ReturnTrue_When_UserWasDeleted() {
    }

    @Test
    void loadUserByUsername() {
        String userName = "user";
        User user = new User(1, "user", "user@email.com", "qwerty", "USER", null, null);
        UserDetailsSecurity expected = new UserDetailsSecurity(user);
        given(userRepository.getUserByUserName(userName)).willReturn(Optional.of(user));

        UserDetails actual = userService.loadUserByUsername(userName);
        assertEquals(expected, actual);
    }
}