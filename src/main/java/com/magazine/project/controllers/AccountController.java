package com.magazine.project.controllers;

import com.magazine.project.entity.User;
import com.magazine.project.services.UserService;
import com.magazine.project.util.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final UserValidator userValidator;
    private final UserService userService;

    public AccountController(UserValidator userValidator, UserService userService) {
        this.userValidator = userValidator;
        this.userService = userService;
    }

    @GetMapping("/login-form")
    public String loginPage(){
        return "account/login-page";
    }

    @GetMapping("/registration")
    public String registrationForm(@ModelAttribute("user") User user){
        return "account/registration-form";
    }

    @PostMapping("/registration")
    public String createAccount(@ModelAttribute("user") @Valid User user, BindingResult result){
        userValidator.validate(user, result);
        if (result.hasErrors()){
            return "account/registration-form";
        }
        user.setRole("USER");
        userService.add(user);
        return "redirect: /account/login-form";
    }
}
