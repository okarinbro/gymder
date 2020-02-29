package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.model.LoginStatus;
import com.white_wolf.threeeyedcrows.model.User;
import com.white_wolf.threeeyedcrows.model.UserLoginData;
import com.white_wolf.threeeyedcrows.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController implements IUserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginData userLoginData) {
        String username = userLoginData.getUsername();
        String password = userLoginData.getPassword();
        LoginStatus loginResult = this.userService.login(username, password);
        if(loginResult.equals(LoginStatus.WRONG_USER))
            return new ResponseEntity<>("User does not exist", HttpStatus.BAD_REQUEST);
        else if(loginResult.equals(LoginStatus.WRONG_PASSWORD))
            return new ResponseEntity<>("Wrong password", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>("Successful login", HttpStatus.OK);
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        boolean loginResult = this.userService.register(user);
        if(!loginResult)
            return new ResponseEntity<>("User with this username already exist",  HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>("User created successfully", HttpStatus.OK);
    }


}
