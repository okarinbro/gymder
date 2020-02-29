package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.model.Invitation;

import java.util.List;

public interface IInvitationService {
    List<Invitation> getInvitations(Long receiverId);
    void postInvitation(Invitation invitation);
}
