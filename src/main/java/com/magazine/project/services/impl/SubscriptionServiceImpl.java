package com.magazine.project.services.impl;

import com.magazine.project.entity.Subscription;
import com.magazine.project.services.SubscriptionService;

import java.util.List;

public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public boolean add(Subscription subscription) {
        return false;
    }

    @Override
    public List<Subscription> getAll() {
        return null;
    }

    @Override
    public List<Subscription> getAllActiveSubscriptions() {
        return null;
    }

    @Override
    public Subscription getById(long id) {
        return null;
    }

    @Override
    public boolean update(long id, Subscription subscription) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
