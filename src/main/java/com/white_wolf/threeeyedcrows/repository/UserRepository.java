package com.white_wolf.threeeyedcrows.repository;

import com.white_wolf.threeeyedcrows.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    @Query("SELECT u FROM User AS u WHERE u.username = :username")
    public Optional<User> getUserByUsername(@Param("username") String username);

}
