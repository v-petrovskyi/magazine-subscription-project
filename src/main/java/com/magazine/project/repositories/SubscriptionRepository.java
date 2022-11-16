package com.magazine.project.repositories;

import com.magazine.project.entity.Magazine;
import com.magazine.project.entity.Subscription;
import com.magazine.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> getAllByUser(User user);
    List<Subscription> getBySubscriptionExpDateAfter(LocalDateTime subscriptionExpDate);
    Optional<Subscription> findFirstByUserAndMagazineOrderBySubscriptionExpDateDesc(User user, Magazine magazine);
}
