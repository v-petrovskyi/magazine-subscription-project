package com.magazine.project.services.impl;

import com.magazine.project.entity.UserInfo;
import com.magazine.project.repositories.UserInfoRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class UserInfoServiceImplTest {
    @Mock
    private UserInfoRepository userInfoRepository;

    private final UserInfoServiceImpl userInfoService;

    public UserInfoServiceImplTest() {
        MockitoAnnotations.openMocks(this);
        this.userInfoService = new UserInfoServiceImpl(userInfoRepository);
    }

    @Test
    void add_Should_ReturnTrue() {
        UserInfo userInfo = new UserInfo(5, LocalDate.of(1995, Month.APRIL, 5), "John", "Smith");
        given(userInfoRepository.save(userInfo)).willReturn(
                new UserInfo(5, LocalDate.of(1995, Month.APRIL, 5), "John", "Smith"));

        boolean result = userInfoService.add(new UserInfo(5, LocalDate.of(1995, Month.APRIL, 5), "John", "Smith"));
        assertTrue(result);
    }

    @Test
    void add_Should_ReturnFalse() {
        given(userInfoRepository.save(null)).willReturn(null);

        boolean result = userInfoService.add(new UserInfo(5, LocalDate.of(1995, Month.APRIL, 5), "John", "Smith"));
        assertFalse(result);
    }

    @Test
    void getById_Should_Return_UserInfo() {
        long idToFind = 5;
        UserInfo expected = new UserInfo(5, LocalDate.of(1995, Month.APRIL, 5), "John", "Smith");

        given(userInfoRepository.findById(idToFind)).willReturn(Optional.of(expected));

        UserInfo actual = userInfoService.getById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    void getById_Should_ThrowEntityNotFoundException_When_ResultIsNull() {
        long idToFind = 5;
        String expectedMessage = "UserInfo with id " + idToFind + " not found";

        given(userInfoRepository.findById(idToFind)).willReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class,()-> userInfoService.getById(idToFind), expectedMessage);
    }


    @Test
    void update_Should_ReturnTrue() {
        UserInfo userInfo = new UserInfo(5, LocalDate.of(1995, Month.APRIL, 5), "John", "Smith");
        given(userInfoRepository.save(userInfo)).willReturn(
                new UserInfo(5, LocalDate.of(1995, Month.APRIL, 5), "John", "Smith"));

        boolean result = userInfoService.update(new UserInfo(5, LocalDate.of(1995, Month.APRIL, 5), "John", "Smith"));

        assertTrue(result);
    }

    @Test
    @Disabled
    void delete_Should_ReturnTrue() {
        long idToDelete = 5;
        UserInfo userToDelete = new UserInfo(5, LocalDate.of(1995, Month.APRIL, 5), "John", "Smith");

//        given(userInfoRepository.delete(userToDelete)).willReturn()

        boolean result = userInfoService.delete(idToDelete);
        assertTrue(result);
    }
}