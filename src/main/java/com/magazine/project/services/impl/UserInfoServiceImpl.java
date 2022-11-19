package com.magazine.project.services.impl;

import com.magazine.project.entity.UserInfo;
import com.magazine.project.repositories.UserInfoRepository;
import com.magazine.project.services.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public boolean add(UserInfo userInfo) {
        log.info("method add(UserInfo userInfo)");
        log.info(userInfo.toString());
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
        log.info("method getById(long id), id = {}", id);
        Optional<UserInfo> optionalUserInfo = userInfoRepository.findById(id);
        try {
            return optionalUserInfo.orElseThrow();
        } catch (NoSuchElementException e) {
            log.error("UserInfo with id " + id + " not found");
            throw new EntityNotFoundException("UserInfo with id " + id + " not found");
        }
    }

    @Override
    public boolean update(UserInfo userInfo) {
        log.info("method update(UserInfo userInfo)");
        log.info(userInfo.toString());
        return add(userInfo);
    }

    @Override
    public boolean delete(long id) {
        log.info("method delete(long id), id = {}", id);
        userInfoRepository.delete(getById(id));
        return userInfoRepository.findById(id).isEmpty();
    }
}
