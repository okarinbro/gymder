package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.model.UserGoal;
import com.white_wolf.threeeyedcrows.repository.UserGoalRepository;

import java.util.List;

public class GoalService implements IGoalService {

    private UserGoalRepository userGoalRepository;

    public GoalService(UserGoalRepository userGoalRepository) {
        this.userGoalRepository = userGoalRepository;
    }

    @Override
    public List<UserGoal> getUserGoals(Long userID) {
        return userGoalRepository.getUserGoals(userID);
    }
}
