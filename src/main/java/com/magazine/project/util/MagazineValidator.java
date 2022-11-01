package com.magazine.project.util;

import com.magazine.project.entity.Magazine;
import com.magazine.project.services.MagazineService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MagazineValidator implements Validator {
    private final MagazineService magazineService;

    public MagazineValidator(MagazineService magazineService) {
        this.magazineService = magazineService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Magazine.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Magazine magazine = (Magazine) target;
        try{
            magazineService.getByTitle(magazine.getTitle());
            errors.rejectValue("title","", "magazine with this title already exists ");
        } catch (Exception ignored) {}
    }
}
