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

    @OneToMany(mappedBy = "id")
    private Set<User> friends;

    @OneToMany(mappedBy = "user")
    private Set<DailyReport> dailyReports;

    @OneToMany(mappedBy = "user")
    private Set<UserGoal> goals;

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public Long getElo() {
        return elo;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public Set<DailyReport> getDailyReports() {
        return dailyReports;
    }

    public Set<UserGoal> getGoals() {
        return goals;
    }
}
