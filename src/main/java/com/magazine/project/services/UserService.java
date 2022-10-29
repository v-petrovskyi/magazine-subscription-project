package com.magazine.project.services;


import com.magazine.project.entity.User;

public interface UserService {
    boolean add(User user);
    User getById(long id);
    User getByUserName(String userName);
    User getByEmail(String email);
    boolean update(User user);
    boolean delete(long id);
}
