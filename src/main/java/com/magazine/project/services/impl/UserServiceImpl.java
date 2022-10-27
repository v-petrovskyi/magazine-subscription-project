package com.magazine.project.services.impl;

import com.magazine.project.entity.User;
import com.magazine.project.services.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public User getById(long id) {
        return null;
    }

    @Override
    public User getByUserName(String userName) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public boolean update(long id, User user) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
