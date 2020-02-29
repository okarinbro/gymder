package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.model.Friendship;
import com.white_wolf.threeeyedcrows.model.User;
import com.white_wolf.threeeyedcrows.repository.FriendshipRepository;
import com.white_wolf.threeeyedcrows.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendshipService implements IFriendshipService{

    FriendshipRepository friendshipRepository;

    public FriendshipService(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    @Override
    public List<Friendship> getUsersFriends(Long id) {
        return this.friendshipRepository.findFriendsByUserId(id);
    }
}
