package com.white_wolf.threeeyedcrows.repository;

import com.white_wolf.threeeyedcrows.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    @Query("FROM Friendship as f WHERE f.root.id = :userId")
    List<Friendship> findFriendsByUserId(@Param("userId") Long userId);
}
