package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.model.Friendship;
import com.white_wolf.threeeyedcrows.model.User;

import java.util.List;

public interface IFriendshipService {
    List<Friendship> getUsersFriends(Long id);
}
