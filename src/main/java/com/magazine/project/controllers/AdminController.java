package com.magazine.project.controllers;

import com.magazine.project.entity.Magazine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("create-magazine")
    public String createMagazine(Model model){
        model.addAttribute("magazine", new Magazine());
        return "admin/add-magazine-view";
    }
}
