package com.magazine.project.services;

import com.magazine.project.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    boolean add(Subscription subscription);
    List<Subscription> getAll();
    List<Subscription> getAllActiveSubscriptions();
    Subscription getById(long id);
    boolean update(long id, Subscription subscription);
    boolean delete(long id);

}
