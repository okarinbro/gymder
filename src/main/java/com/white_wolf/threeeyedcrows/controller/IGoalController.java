package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.model.UserGoal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IGoalController {

    List<UserGoal> getUserGoals(@RequestParam Long userId);

    void addUserGoal(UserGoal userGoal);

    void updateUserGoal(UserGoal userGoal);
}
