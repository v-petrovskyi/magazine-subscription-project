package com.magazine.project.controllers;

import com.magazine.project.entity.Magazine;
import com.magazine.project.services.MagazineService;

import com.magazine.project.services.SubscriptionService;
import com.magazine.project.util.MagazineValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final MagazineService magazineService;
    private final SubscriptionService subscriptionService;
    private final MagazineValidator magazineValidator;

    public AdminController(MagazineService magazineService, SubscriptionService subscriptionService, MagazineValidator magazineValidator) {
        this.magazineService = magazineService;
        this.subscriptionService = subscriptionService;
        this.magazineValidator = magazineValidator;
    }

    @GetMapping("/create-magazine")
    public String createMagazine(Model model) {
        log.info("method createMagazine");
        model.addAttribute("magazine", new Magazine());
        return "admin/add-magazine-view";
    }

    @PostMapping("/create-magazine")
    public String addMagazineToBD(@ModelAttribute("magazine") @Valid Magazine magazine, BindingResult result) {
        log.info("method addMagazineToBD");
        magazineValidator.validate(magazine, result);
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            return "admin/add-magazine-view";
        }
        magazineService.add(magazine);
        log.info(magazine.toString());
        return "redirect:/home";
    }

    @GetMapping("/all-subscriptions")
    public String showAllSubscriptionsPage(Model model){
        model.addAttribute("allSubscriptions", subscriptionService.getAll());
        log.info("method showAllSubscriptionsPage");

        return "admin/all-subscriptions-view";
    }

    @GetMapping("/admin-page")
    public String showAdminPage(){
        return "admin/admin-page";
    }
}
