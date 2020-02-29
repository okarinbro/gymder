package com.white_wolf.threeeyedcrows.repository;

import com.white_wolf.threeeyedcrows.model.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long> {

    @Query("FROM Invitation i WHERE i.receiver.id = :userId")
    List<Invitation> findByReceiverId(@Param("userId") Long userId);
}
