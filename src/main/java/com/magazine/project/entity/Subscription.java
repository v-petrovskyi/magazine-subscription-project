package com.magazine.project.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "subscription_date", nullable = false)
    private LocalDateTime subscriptionDate;
    @Column(name = "subscription_start_date", nullable = false)
    private LocalDateTime subscriptionStartDate;

    @Column(name = "subscription_exp_date", nullable = false)
    private LocalDateTime subscriptionExpDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "magazine_id")
    private Magazine magazine;

    @Column(scale = 2)
    private double amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(id, that.id) && Objects.equals(subscriptionStartDate, that.subscriptionStartDate) && Objects.equals(subscriptionExpDate, that.subscriptionExpDate) && Objects.equals(user, that.user) && Objects.equals(magazine, that.magazine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subscriptionStartDate, subscriptionExpDate, user, magazine, amount);
    }

    }
