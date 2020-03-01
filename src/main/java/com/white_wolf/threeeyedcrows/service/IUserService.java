package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.model.LoginStatus;
import com.white_wolf.threeeyedcrows.model.User;
import com.white_wolf.threeeyedcrows.model.UserGymderData;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    LoginStatus login(String username, String password);

    boolean register(User user);

    List<UserGymderData> getUserGymderData(Long id);

    Optional<User> getUser(Long id);

    Optional<User> getUserByUserName(String username);
}
