package com.magazine.project.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column
    private double price;

    @Column(name = "image_path")
    private String imagePath;

//    @Column(name = "subscription_term_months")
//    private int subscriptionTerm;

    }
