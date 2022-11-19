package com.magazine.project.controllers;

import com.magazine.project.dto.UserDto;
import com.magazine.project.dto.UserDtoTransfer;
import com.magazine.project.entity.Subscription;
import com.magazine.project.entity.User;
import com.magazine.project.entity.UserInfo;
import com.magazine.project.exception.WrongTermException;
import com.magazine.project.security.UserDetailsSecurity;
import com.magazine.project.services.MagazineService;
import com.magazine.project.services.SubscriptionService;
import com.magazine.project.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    private final SubscriptionService subscriptionService;
    private final MagazineService magazineService;
    private final UserService userService;


    @Autowired
    public UserController(SubscriptionService subscriptionService, MagazineService magazineService, UserService userService) {
        this.subscriptionService = subscriptionService;
        this.magazineService = magazineService;
        this.userService = userService;
    }

    @GetMapping("/info")
    public String showUserPage(Model model) {
        User userFromDB = getUser();
        if (userFromDB.getUserInfo() == null) {
            userFromDB.setUserInfo(new UserInfo());
        }
        UserDto userDto = UserDtoTransfer.convertUserToUserDto(userFromDB);
        model.addAttribute("user", userDto);
        return "user/info";
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute("user") UserDto userDto, BindingResult result){
        log.info("update user, userDto = {}", userDto);
        User userFromDB = getUser();
        User updatedUser = UserDtoTransfer.convertUserDtoToUser(userDto, userFromDB);
        log.info("before update");
        userService.update(updatedUser);
        return "redirect:/user/info";
    }


    @GetMapping("/subscriptions")
    public String showUserSubscriptions(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsSecurity principal = (UserDetailsSecurity) authentication.getPrincipal();
        User user = principal.getUser();
        List<Subscription> allByUser = subscriptionService.getAllByUser(user.getId());
        model.addAttribute("subscriptions", allByUser);
        return "user/user-subscriptions-view";
    }


    @PostMapping("/subscribe")
    public String subscribeToMagazine(@RequestParam("month") int month,
                                      @RequestParam("magazine_id") int magazineId) {
        log.info("subscribeToMagazine");
        log.info("month={}", month);
        log.info("magazineId={}", magazineId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsSecurity principal = (UserDetailsSecurity) authentication.getPrincipal();
        User user = principal.getUser();
        if (!subscriptionService.subscribeUserToMagazine(month, user.getId(), magazineId)){
            throw new WrongTermException("something was wrong");
        }
        return "redirect:/user/info";
    }

    private User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsSecurity principal = (UserDetailsSecurity) authentication.getPrincipal();
        User user = principal.getUser();
        return userService.getById(user.getId());
    }
}
