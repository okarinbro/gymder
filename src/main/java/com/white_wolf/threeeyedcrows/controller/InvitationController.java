package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.model.Invitation;
import com.white_wolf.threeeyedcrows.service.IInvitationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invitation/")
public class InvitationController implements IInvitationController {

    private IInvitationService invitationService;

    public InvitationController(IInvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @Override
    @GetMapping
    public List<Invitation> getInvitations(Long receiverId) {
        return invitationService.getInvitations(receiverId);
    }

    @Override
    @PostMapping
    public void postInvitation(@RequestBody Invitation invitation) {
        invitationService.postInvitation(invitation);
    }
}
