package com.white_wolf.threeeyedcrows.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name = "users")
@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "id")
    private Set<User> friends;

    @OneToMany(mappedBy = "user")
    private Set<DailyReport> dailyReports;

    @OneToMany(mappedBy = "user")
    private Set<UserGoal> goals;
}
