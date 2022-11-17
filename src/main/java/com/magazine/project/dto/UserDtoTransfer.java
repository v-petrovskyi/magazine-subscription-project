package com.magazine.project.dto;

import com.magazine.project.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
public class UserDtoTransfer {
    public static UserDto convertUserToUserDto(User user) {
        log.info("convert User To UserDto: {}", user.toString());
        String birthDate = null;
        if (user.getUserInfo().getBirthDate() != null) {
            birthDate = user.getUserInfo().getBirthDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        return new UserDto(
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                birthDate,
                user.getUserInfo().getName(),
                user.getUserInfo().getSurname());
    }
    public static User convertUserDtoToUser(UserDto userDto, User user){
        log.info("convert UserDto To User: {} | {}", userDto, user);
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
        LocalDate parsed = LocalDate.parse(userDto.getBirthDate());
        user.getUserInfo().setBirthDate(parsed);
        user.getUserInfo().setName(userDto.getName());
        user.getUserInfo().setSurname(userDto.getSurname());
        return user;
    }
}
