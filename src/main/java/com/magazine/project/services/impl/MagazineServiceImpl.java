package com.magazine.project.services.impl;

import com.magazine.project.entity.Magazine;
import com.magazine.project.exception.IncorrectPageException;
import com.magazine.project.repositories.MagazineRepository;
import com.magazine.project.services.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MagazineServiceImpl implements MagazineService {

    private final MagazineRepository magazineRepository;

    public MagazineServiceImpl(MagazineRepository magazineRepository) {
        this.magazineRepository = magazineRepository;
    }

    @Override
    public boolean add(Magazine magazine) {
        Magazine saved = magazineRepository.save(magazine);
        return saved.getTitle().equals(magazine.getTitle());
    }

    @Override
    public List<Magazine> getAll() {
        List<Magazine> all = magazineRepository.findAll();
        return all.isEmpty() ? new ArrayList<>() : all;
    }

    @Override
    public List<Magazine> getAllActive() {
        List<Magazine> magazines = magazineRepository.getAllByActiveIsTrue();
        return magazines.isEmpty() ? new ArrayList<>() : magazines;
    }

    @Override
    public Magazine getById(long id) {
        Optional<Magazine> optionalMagazine = magazineRepository.findById(id);
        try {
            return optionalMagazine.orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("Magazine with id " + id + " not found");
        }
    }

    @Override
    public Magazine getByTitle(String title) {
        Optional<Magazine> optionalMagazine = magazineRepository.findByTitle(title);
        try {
            return optionalMagazine.orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("Magazine with title " + title + " not found");
        }
    }

    @Override
    public boolean update(Magazine magazine) {
        return add(magazine);
    }

    @Override
    public boolean delete(long id) {
        magazineRepository.delete(getById(id));
        return magazineRepository.findById(id).isEmpty();
    }

    @Override
    public List<Magazine> getSelectedPageOfMagazines(int page, int pageSize) throws IncorrectPageException {
        List<Magazine> all = getAll();
        int fromIndex = (page * pageSize) - pageSize;
        int toIndex = fromIndex + pageSize;
        try {
            return all.subList(fromIndex, toIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new IncorrectPageException("page " + page + " not exist");
        }
    }
}
