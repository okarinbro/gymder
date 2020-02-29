package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.model.UserGoal;
import com.white_wolf.threeeyedcrows.service.IGoalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/goal/")
public class GoalController implements IGoalController {

    private IGoalService goalService;

    public GoalController(IGoalService goalService) {
        this.goalService = goalService;
    }

    @Override
    @GetMapping("hello/")
    public List<UserGoal> getUserGoals(Long userID) {
        return this.goalService.getUserGoals(userID);
    }

    @Override
    public void addUserGoal(UserGoal userGoal) {

    }

    @Override
    public void updateUserGoal(UserGoal userGoal) {

    }
}
