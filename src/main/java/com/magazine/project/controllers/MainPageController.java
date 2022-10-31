package com.magazine.project.controllers;

import com.magazine.project.security.UserDetailsSecurity;
import com.magazine.project.services.MagazineService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {
    private final MagazineService magazineService;

    public MainPageController(MagazineService magazineService) {
        this.magazineService = magazineService;
    }


    @GetMapping({"/", "/home"})
    public String showMainPage(Model model){
        model.addAttribute("magazines", magazineService.getAllActive());
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsSecurity principal = (UserDetailsSecurity) authentication.getPrincipal();
//        System.out.println(principal.getUser());
        return "main-page";
    }

    @RequestMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }
}
