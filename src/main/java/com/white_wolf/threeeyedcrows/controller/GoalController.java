package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.exception.NotFoundException;
import com.white_wolf.threeeyedcrows.model.UserGoal;
import com.white_wolf.threeeyedcrows.service.IGoalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goal/")
public class GoalController implements IGoalController {

    private IGoalService goalService;

    public GoalController(IGoalService goalService) {
        this.goalService = goalService;
    }

    @Override
    @GetMapping
    public List<UserGoal> getUserGoals(Long userID) {
        return this.goalService.getUserGoals(userID);
    }

    @Override
    @PostMapping
    public void addUserGoal(@RequestBody UserGoal userGoal) {
        this.goalService.addUserGoal(userGoal);
    }

    @Override
    @PutMapping
    public void updateUserGoal(@RequestBody UserGoal userGoal) throws NotFoundException {
        this.goalService.updateUserGoal(userGoal);
    }
}
