package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.model.UserGoals;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/goal")
public interface IGoalController {
    List<UserGoals> getUserGoals(Long userID);
    void addUserGoal(UserGoals userGoal);
    void updateUserGoal(UserGoals userGoal);
}
