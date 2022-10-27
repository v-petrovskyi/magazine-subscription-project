package com.magazine.project.services.impl;

import com.magazine.project.entity.Magazine;
import com.magazine.project.services.MagazineService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MagazineServiceImpl implements MagazineService {
    @Override
    public boolean add(Magazine magazine) {
        return false;
    }

    @Override
    public List<Magazine> getAll() {
        return null;
    }

    @Override
    public List<Magazine> getAllActive() {
        return null;
    }

    @Override
    public Magazine getById(long id) {
        return null;
    }

    @Override
    public Magazine getByTitle(String title) {
        return null;
    }

    @Override
    public boolean update(long id, Magazine magazine) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
