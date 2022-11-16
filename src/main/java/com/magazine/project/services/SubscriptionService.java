package com.magazine.project.services;

import com.magazine.project.entity.Magazine;
import com.magazine.project.entity.Subscription;
import com.magazine.project.entity.User;

import java.util.List;

public interface SubscriptionService {

    boolean add(Subscription subscription);
    List<Subscription> getAll();
    List<Subscription> getAllActiveSubscriptions();
    Subscription getById(long id);
    boolean update(Subscription subscription);
    boolean delete(long id);

    boolean subscribeUserToMagazine(int term, long userId, long magazineId);
}
