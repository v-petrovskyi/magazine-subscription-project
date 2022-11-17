package com.magazine.project.dto;

import com.magazine.project.entity.UserInfo;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userName;
    private String email;
    private String password;
    private String birthDate;
    private String name;
    private String surname;
}
