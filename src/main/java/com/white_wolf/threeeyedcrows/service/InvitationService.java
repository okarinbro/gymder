package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.model.Invitation;
import com.white_wolf.threeeyedcrows.repository.InvitationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class InvitationService implements IInvitationService {

    private InvitationRepository invitationRepository;

    public InvitationService(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    @Override
    public List<Invitation> getInvitations(@RequestParam Long receiverId) {
        return invitationRepository.findByReceiverId(receiverId);
    }

    @Override
    public List<Invitation> getSentInvitation(Long senderId) {
        return invitationRepository.findBySenderId(senderId);
    }

    @Override
    public void postInvitation(Invitation invitation) {
        invitation.setId(null);

        invitationRepository.save(invitation);
    }
}
