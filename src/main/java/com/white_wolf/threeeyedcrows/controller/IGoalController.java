package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.exception.NotFoundException;
import com.white_wolf.threeeyedcrows.model.Goal;
import com.white_wolf.threeeyedcrows.model.UserGoal;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IGoalController {

    List<UserGoal> getUserGoals(@RequestParam Long userId);

    void addUserGoal(UserGoal userGoal);

    void updateUserGoal(UserGoal userGoal) throws NotFoundException;

    List<Goal> getAllGoals();
}
