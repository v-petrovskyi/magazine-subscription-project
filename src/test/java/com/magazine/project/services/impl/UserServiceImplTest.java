package com.magazine.project.services.impl;

import com.magazine.project.entity.User;
import com.magazine.project.repositories.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

        boolean result = userService.add(user);
        assertTrue(result);
    }

    @Test
    void getById_Should_ReturnCorrectUser() {
        long id = 1;
        User expected = new User(1, "user", "user@email.com", "qwerty", "USER", null, null);

        given(userRepository.findById(id)).willReturn(Optional.of(expected));

        User actual = userService.getById(id);
        assertEquals(actual, expected);
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

        User result = userService.getByUserName(userName);
        assertEquals(expected, result);
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

        User result = userService.getByEmail(userEmail);
        assertEquals(expected, result);
    }

    @Test
    void update() {
    }

    @Test
    @Disabled
    void delete_Should_ReturnTrue_When_UserWasDeleted() {
        long id = 1;
        User expected = new User(1, "user", "user@email.com", "qwerty", "USER", null, null);
        given(userRepository.findById(id)).willReturn(Optional.of(expected));
        boolean result = userService.delete(id);
        assertTrue(result);
    }

    @Test
    void loadUserByUsername() {

    }
}