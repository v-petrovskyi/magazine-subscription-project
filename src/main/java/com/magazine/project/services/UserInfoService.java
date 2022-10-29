package com.magazine.project.services;

import com.magazine.project.entity.UserInfo;

public interface UserInfoService {
    boolean add(UserInfo userInfo);
    UserInfo getById(long id);
    boolean update(UserInfo userInfo);
    boolean delete(long id);
}
