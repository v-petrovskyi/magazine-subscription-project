package com.magazine.project.controllers;

import com.magazine.project.entity.User;
import com.magazine.project.exception.IncorrectPageException;
import com.magazine.project.models.Page;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Slf4j
@Controller
public class MainController {
    private final MagazineService magazineService;

    public MainController(MagazineService magazineService) {
        this.magazineService = magazineService;
    }

    @GetMapping({"/", "/home"})
    public String showMainPage(Model model,
                               @RequestParam(name = "page", required = false) Optional<Integer> page,
                               @RequestParam(name = "size", required = false) Optional<Integer> size) throws IncorrectPageException {
        log.info("method showMainPage");
        log.info("page = {}", page);
        log.info("size = {}", size);
        Page selectedPageOfMagazines = magazineService.getSelectedPageOfMagazines(page.orElse(1), size.orElse(9));
        model.addAttribute("magazines", selectedPageOfMagazines.getMagazineList());
        int currentPage = selectedPageOfMagazines.getCurrentPage();
        model.addAttribute("currentPage", currentPage);
        log.info("current page = {}", currentPage);
        int lastPage = selectedPageOfMagazines.getMaxPage();
        model.addAttribute("lastPage", lastPage);
        log.info("last page = {}", lastPage);
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
