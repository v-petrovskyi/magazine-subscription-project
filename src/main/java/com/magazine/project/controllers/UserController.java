package com.magazine.project.controllers;

import com.magazine.project.entity.Magazine;
import com.magazine.project.entity.Subscription;
import com.magazine.project.entity.User;
import com.magazine.project.security.UserDetailsSecurity;
import com.magazine.project.services.MagazineService;
import com.magazine.project.services.SubscriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    private final SubscriptionService subscriptionService;
    private final MagazineService magazineService;

    @Autowired
    public UserController(SubscriptionService subscriptionService, MagazineService magazineService) {
        this.subscriptionService = subscriptionService;
        this.magazineService = magazineService;
    }

    @GetMapping("/info")
    public String showUserPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsSecurity principal = (UserDetailsSecurity) authentication.getPrincipal();
        User user = principal.getUser();
        List<Subscription> allByUser = subscriptionService.getAllByUser(user.getId());
        model.addAttribute("subscriptions", allByUser);
        return "user/info";
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
//        Magazine magazine = magazineService.getById(magazineId);
        subscriptionService.subscribeUserToMagazine(month, user.getId(), magazineId);
        return "redirect:/user/info";
    }
}
