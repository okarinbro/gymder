package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.exception.NotFoundException;
import com.white_wolf.threeeyedcrows.model.Goal;
import com.white_wolf.threeeyedcrows.model.UserGoal;
import com.white_wolf.threeeyedcrows.repository.GoalRepository;
import com.white_wolf.threeeyedcrows.repository.UserGoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService implements IGoalService {

    private UserGoalRepository userGoalRepository;
    private GoalRepository goalRepository;

    public GoalService(UserGoalRepository userGoalRepository, GoalRepository goalRepository) {
        this.userGoalRepository = userGoalRepository;
        this.goalRepository = goalRepository;
    }

    @Override
    public List<UserGoal> getUserGoals(Long userID) {
        return this.userGoalRepository.getUserGoals(userID);
    }

    @Override
    public void addUserGoal(UserGoal userGoal) {
        userGoal.setId(null);

        this.userGoalRepository.save(userGoal);
    }

    @Override
    public void updateUserGoal(UserGoal userGoal) throws NotFoundException {
        Optional<UserGoal> currentGoal = this.userGoalRepository.findById(userGoal.getId());

        if (currentGoal.isEmpty()) {
            throw new NotFoundException("User goal not found");
        } else {
            userGoalRepository.save(userGoal);
        }
    }

    @Override
    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }


}
