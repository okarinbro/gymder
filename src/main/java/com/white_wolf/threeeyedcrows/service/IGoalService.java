package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.model.UserGoal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IGoalService {

    List<UserGoal> getUserGoals(Long userID);
}
