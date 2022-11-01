package com.magazine.project.controllers;

import com.magazine.project.entity.User;
import com.magazine.project.security.UserDetailsSecurity;
import com.magazine.project.services.MagazineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
public class MainPageController {
    private final MagazineService magazineService;

    public MainPageController(MagazineService magazineService) {
        this.magazineService = magazineService;
    }


    @GetMapping({"/", "/home"})
    public String showMainPage(Model model) {
        log.info("method showMainPage");
        model.addAttribute("magazines", magazineService.getAllActive());
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsSecurity principal = (UserDetailsSecurity) authentication.getPrincipal();
            User user = principal.getUser();
//            System.out.println(user); // todo прибрати в майбутньому
            model.addAttribute("user", user);
            log.info(user.toString());
        } catch (Exception e) {
            model.addAttribute("user", "null");
            log.info("unauthorized user");
        }
        return "main-page";
    }

    @RequestMapping("/access-denied")
    public String accessDenied() {
        log.info("method accessDenied");
        return "access-denied";
    }
}
