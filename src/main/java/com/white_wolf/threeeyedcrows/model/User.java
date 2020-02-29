package com.white_wolf.threeeyedcrows.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String password;

    private String name;

    private String email;

    private String username;

    private String description;

    private Long elo;

    @OneToMany(mappedBy = "id")
    private Set<User> friends;

    @OneToMany(mappedBy = "user_id")
    private Set<DailyReport> dailyReports;
}
