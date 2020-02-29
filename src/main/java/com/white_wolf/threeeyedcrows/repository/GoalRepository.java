package com.white_wolf.threeeyedcrows.repository;

import com.white_wolf.threeeyedcrows.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}
