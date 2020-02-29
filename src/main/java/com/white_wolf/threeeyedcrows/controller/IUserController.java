package com.white_wolf.threeeyedcrows.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/user")
public interface IUserController {

    ResponseEntity<String> login(String username, String password);


}
