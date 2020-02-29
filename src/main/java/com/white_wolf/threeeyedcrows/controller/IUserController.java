package com.white_wolf.threeeyedcrows.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.white_wolf.threeeyedcrows.model.User;
import com.white_wolf.threeeyedcrows.model.UserGymderData;
import com.white_wolf.threeeyedcrows.model.UserLoginData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/user")
public interface IUserController {

    ResponseEntity<String> login(UserLoginData userLoginData);

    ResponseEntity<String> register(User user);

    List<UserGymderData> getUserGymderData(Long id);
}
