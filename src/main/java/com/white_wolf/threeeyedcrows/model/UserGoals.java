package com.white_wolf.threeeyedcrows.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "user_goals")
@Entity
public class UserGoals {
    private Long weekNumber;
    private boolean completed;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal")
    private Goal goal;
}
