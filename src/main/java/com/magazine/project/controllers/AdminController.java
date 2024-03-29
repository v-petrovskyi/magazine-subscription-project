package com.magazine.project.controllers;

import com.magazine.project.entity.Magazine;
import com.magazine.project.services.MagazineService;

import com.magazine.project.services.SubscriptionService;
import com.magazine.project.util.MagazineValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/update-magazine/{magazine_id}")
    public String showPageForUpdateMagazine(Model model, @PathVariable Long magazine_id) {
        log.info("method showPageForUpdateMagazine");
        log.info("magazine_id = {}", magazine_id);
        model.addAttribute("magazine", magazineService.getById(magazine_id));
        return "admin/update-magazine-view";
    }

    @PostMapping("/update-magazine/{magazine_id}")
    public String updateMagazine(@ModelAttribute("magazine") Magazine magazine, BindingResult result, @PathVariable Long magazine_id) {
        log.info("method updateMagazine");
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            return "admin/update-magazine-view";
        }
        magazine.setId(magazine_id);
        magazineService.update(magazine);
        log.info(magazine.toString());
        return "redirect:/magazine/" + magazine_id;
    }


    @GetMapping("/all-subscriptions")
    public String showAllSubscriptionsPage(Model model) {
        model.addAttribute("allSubscriptions", subscriptionService.getAll());
        log.info("method showAllSubscriptionsPage");

        return "admin/all-subscriptions-view";
    }

    @GetMapping("/magazines")
    public String showAllMagazines(Model model){
        log.info("method showAllMagazines");
        model.addAttribute("allMagazines", magazineService.getAll());
        return "admin/all-magazines-view";
    }


    @GetMapping("/admin-page")
    public String showAdminPage() {
        return "admin/admin-page";
    }
}
