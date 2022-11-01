package com.magazine.project.controllers;

import com.magazine.project.entity.User;
import com.magazine.project.services.UserService;
import com.magazine.project.services.impl.UserRegistrationServiceImpl;
import com.magazine.project.util.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
@Slf4j
@Controller
@RequestMapping("/account")
public class AccountController {

    private final UserValidator userValidator;
    private final UserService userService;
    private final UserRegistrationServiceImpl userRegistrationService;

    public AccountController(UserValidator userValidator, UserService userService, UserRegistrationServiceImpl userRegistrationService) {
        this.userValidator = userValidator;
        this.userService = userService;
        this.userRegistrationService = userRegistrationService;
    }

    @GetMapping("/login-form")
    public String loginPage(){
        log.info("method loginPage");
        return "account/login-page";
    }

    @GetMapping("/registration")
    public String registrationForm(@ModelAttribute("user") User user){
        log.info("method registrationForm");
        return "account/registration-form";
    }

    @PostMapping("/registration")
    public String createAccount(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        log.info("method createAccount");
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            log.error(bindingResult.getAllErrors().toString());
            return "account/registration-form";
        }
        userRegistrationService.register(user);
        log.info("register user {}", user);
        return "redirect: /account/login-form";
    }
}
