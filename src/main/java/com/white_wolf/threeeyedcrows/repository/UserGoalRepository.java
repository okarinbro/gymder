package com.white_wolf.threeeyedcrows.repository;

import com.white_wolf.threeeyedcrows.model.UserGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGoalRepository extends JpaRepository<UserGoal, Long> {

    @Query("SELECT u FROM UserGoal AS u WHERE u.user.id = :userId")
    List<UserGoal> getUserGoals(@Param("userId") Long userId);
}
