package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.model.Invitation;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/invitation")
public interface IInvitationController {
    List<Invitation> getInvitations(Long receiverId);
    void postInvitation(Invitation invitation);
}
