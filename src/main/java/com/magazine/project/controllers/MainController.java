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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class MainController {
    private final MagazineService magazineService;

    public MainController(MagazineService magazineService) {
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
            model.addAttribute("user", user);
            log.info(user.toString());
        } catch (Exception e) {
            model.addAttribute("user", "null");
            log.info("unauthorized user");
        }
        return "main-page";
    }

    @GetMapping("/magazine/{id}")
    public String showMagazinePage(@PathVariable String id, Model model) throws Exception {
        try {
            model.addAttribute("magazine", magazineService.getById(Long.parseLong(id)));
            return "magazine-page-view";
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
            throw new Exception("id is not correct");
        }
    }

    @RequestMapping("/access-denied")
    public String accessDenied() {
        log.info("method accessDenied");
        return "access-denied";
    }
}
