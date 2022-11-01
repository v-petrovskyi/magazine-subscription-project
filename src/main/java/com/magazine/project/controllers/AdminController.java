package com.magazine.project.controllers;

import com.magazine.project.entity.Magazine;
import com.magazine.project.services.MagazineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
private final MagazineService magazineService;

    public AdminController(MagazineService magazineService) {
        this.magazineService = magazineService;
    }

    @GetMapping("/create-magazine")
    public String createMagazine(Model model){
        model.addAttribute("magazine", new Magazine());
        return "admin/add-magazine-view";
    }

    @PostMapping("/create-magazine")
    public String addMagazineToBD(@ModelAttribute ("magazine") @Valid Magazine magazine, BindingResult result){
        if (result.hasErrors()){
            return "admin/add-magazine-view";
        }

        return "";
    }

}
