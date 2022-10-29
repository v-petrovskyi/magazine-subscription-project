package com.magazine.project.controllers;

import com.magazine.project.services.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {
    private final MagazineService magazineService;

    public MainPageController(MagazineService magazineService) {
        this.magazineService = magazineService;
    }


    @GetMapping("/")
    public String showMainPage(){
        return "main-page";
    }
}
