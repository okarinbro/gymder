package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.exception.NotFoundException;
import com.white_wolf.threeeyedcrows.model.Goal;
import com.white_wolf.threeeyedcrows.model.UserGoal;

import java.util.List;

public interface IGoalService {

    List<UserGoal> getUserGoals(Long userID);

    void addUserGoal(UserGoal userGoal);

    void updateUserGoal(UserGoal userGoal) throws NotFoundException;

    List<Goal> getAllGoals();
}
