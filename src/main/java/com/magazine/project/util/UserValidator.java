package com.magazine.project.util;

import com.magazine.project.entity.User;
import com.magazine.project.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityNotFoundException;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        try {
            userService.getByUserName(user.getUserName());
        } catch (Exception e) {
            try {
                userService.getByEmail(user.getEmail());
            } catch (Exception exception) {
                return;
            }
            errors.rejectValue("email", "", "user with this email already exists");
        }
        errors.rejectValue("userName", "", "user with this username already exists");
    }
}
