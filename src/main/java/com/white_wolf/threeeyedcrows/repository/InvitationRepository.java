package com.white_wolf.threeeyedcrows.repository;

import com.white_wolf.threeeyedcrows.model.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
}
