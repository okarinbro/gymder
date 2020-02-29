package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.model.UserGoal;

import java.util.List;

public interface IGoalService {

    List<UserGoal> getUserGoals(Long userID);
}
