package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.model.User;
import com.white_wolf.threeeyedcrows.model.UserLoginData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/user")
public interface IUserController {

    ResponseEntity<String> login(UserLoginData userLoginData);

    ResponseEntity<String> register(User user);

}
