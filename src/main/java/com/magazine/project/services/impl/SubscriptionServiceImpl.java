package com.magazine.project.services.impl;

import com.magazine.project.entity.Magazine;
import com.magazine.project.entity.Subscription;
import com.magazine.project.entity.User;
import com.magazine.project.repositories.SubscriptionRepository;
import com.magazine.project.services.MagazineService;
import com.magazine.project.services.SubscriptionService;
import com.magazine.project.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final MagazineService magazineService;
    private final UserService userService;
    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionServiceImpl(MagazineService magazineService, UserService userService, SubscriptionRepository subscriptionRepository) {
        this.magazineService = magazineService;
        this.userService = userService;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public boolean add(Subscription subscription) {
        Subscription saved = subscriptionRepository.save(subscription);
        return saved.getId() > 0;
    }

    @Override
    public List<Subscription> getAll() {
        List<Subscription> all = subscriptionRepository.findAll();
        return all.isEmpty() ? new ArrayList<>() : all;
    }

    @Override
    public List<Subscription> getAllActiveSubscriptions() {
        List<Subscription> allActive = subscriptionRepository.getBySubscriptionExpDateAfter(LocalDateTime.now());
        return allActive.isEmpty() ? new ArrayList<>() : allActive;
    }

    @Override
    public Subscription getById(long id) {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(id);
        try {
            return optionalSubscription.orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("Magazine with id " + id + " not found");
        }
    }

    @Override
    public boolean update(Subscription subscription) {
        return add(subscription);
    }

    @Override
    public boolean delete(long id) {
        subscriptionRepository.delete(getById(id));
        return subscriptionRepository.findById(id).isEmpty();
    }

    @Override
    public List<Subscription> getAllByUser(long userId) {
        log.info("method getAllByUser");
        log.info("user id = {}", userId);
        User user = userService.getById(userId);
        List<Subscription> allByUser = subscriptionRepository.getAllByUser(user);
        return allByUser.isEmpty() ? new ArrayList<>() : allByUser;
    }

    @Override
    public boolean subscribeUserToMagazine(int term, long userId, long magazineId) { // todo не впевнений що це має бути тут а не в іншому класі
        log.info("subscribeUserToMagazine");
        log.info(String.valueOf(term));
        log.info(String.valueOf(userId));
        log.info(String.valueOf(magazineId));
        Magazine magazine = magazineService.getById(magazineId);
        User user = userService.getById(userId);
        Subscription newSubscription = new Subscription();
        newSubscription.setSubscriptionDate(LocalDateTime.now());
        newSubscription.setMagazine(magazine);
        newSubscription.setUser(user);
        newSubscription.setAmount(magazine.getPrice() * term);
        for (Subscription subscription : user.getSubscriptions()) {
            if (subscription.getMagazine().getId() == magazine.getId()) {
                newSubscription.setSubscriptionStartDate(subscription.getSubscriptionExpDate());
            }
        }
        if (newSubscription.getSubscriptionExpDate() == null) {
            newSubscription.setSubscriptionStartDate(LocalDateTime.now());
        }
        newSubscription.setSubscriptionExpDate(newSubscription.getSubscriptionStartDate().plusMonths(term));
        return add(newSubscription);
    }
}
