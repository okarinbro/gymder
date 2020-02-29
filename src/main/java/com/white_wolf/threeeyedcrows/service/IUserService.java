package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.model.LoginStatus;
import com.white_wolf.threeeyedcrows.model.User;

public interface IUserService {
    LoginStatus login(String username, String password);
    boolean register(User user);
}
