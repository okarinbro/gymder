package com.white_wolf.threeeyedcrows.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EnableAutoConfiguration
@Data
@Table(name = "user_goals")
public class UserGoals {
    private Long weekNumber;
    private boolean completed;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal")
    private Goal goal;
}
