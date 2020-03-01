package com.white_wolf.threeeyedcrows.repository;

import com.white_wolf.threeeyedcrows.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
}
