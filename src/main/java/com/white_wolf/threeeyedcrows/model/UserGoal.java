package com.white_wolf.threeeyedcrows.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_goals")
public class UserGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long weekNumber;

    private boolean completed;

    @ManyToOne(fetch = FetchType.EAGER)
    private Goal goal;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public boolean isCompleted() {
        return completed;
    }

}
