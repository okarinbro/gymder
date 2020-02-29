package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.model.UserGoal;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/goal")
public interface IGoalController {
    List<UserGoal> getUserGoals(Long userID);
    void addUserGoal(UserGoal userGoal);
    void updateUserGoal(UserGoal userGoal);
}
