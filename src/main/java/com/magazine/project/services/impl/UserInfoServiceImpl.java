package com.magazine.project.services.impl;

import com.magazine.project.entity.UserInfo;
import com.magazine.project.repositories.UserInfoRepository;
import com.magazine.project.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public boolean add(UserInfo userInfo) {
        UserInfo saved = userInfoRepository.save(userInfo);
        try {
            saved.getId();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public UserInfo getById(long id) {
        Optional<UserInfo> optionalUserInfo = userInfoRepository.findById(id);
        try {
            return optionalUserInfo.orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("UserInfo with id " + id + " not found");
        }
    }

    @Override
    public boolean update(UserInfo userInfo) {
        return add(userInfo);
    }

    @Override
    public boolean delete(long id) {
        userInfoRepository.delete(getById(id));
        return userInfoRepository.findById(id).isEmpty();
    }
}
