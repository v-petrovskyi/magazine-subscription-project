package com.magazine.project.services;

import com.magazine.project.entity.Magazine;
import com.magazine.project.exception.IncorrectPageException;
import com.magazine.project.models.Page;

import java.util.List;

public interface MagazineService {

    boolean add(Magazine magazine);

    List<Magazine> getAll();

    List<Magazine> getAllActive();

    Magazine getById(long id);

    Magazine getByTitle(String title);

    boolean update(Magazine magazine);

    boolean delete(long id);

    Page getSelectedPageOfMagazines(int page, int qtyOnPage) throws IncorrectPageException;


}
