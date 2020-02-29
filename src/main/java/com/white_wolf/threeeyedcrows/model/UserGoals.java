package com.white_wolf.threeeyedcrows.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_goals")
public class UserGoals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long weekNumber;
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal")
    private Goal goal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_fk")
    private User user;
}
