package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.exception.NotFoundException;

public interface IFriendshipController {
    void addFriendship(long user1, String friendUsername) throws NotFoundException;
}
