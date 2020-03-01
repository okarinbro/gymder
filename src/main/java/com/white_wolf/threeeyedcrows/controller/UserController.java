package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.model.LoginStatus;
import com.white_wolf.threeeyedcrows.model.User;
import com.white_wolf.threeeyedcrows.model.UserGymderData;
import com.white_wolf.threeeyedcrows.model.UserLoginData;
import com.white_wolf.threeeyedcrows.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/")
public class UserController implements IUserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping("login/")
    public ResponseEntity<String> login(@RequestBody UserLoginData userLoginData) {
        String username = userLoginData.getUsername();
        String password = userLoginData.getPassword();
        LoginStatus loginResult = this.userService.login(username, password);
        if (loginResult.equals(LoginStatus.WRONG_USER))
            return new ResponseEntity<>("User does not exist", HttpStatus.BAD_REQUEST);
        else if (loginResult.equals(LoginStatus.WRONG_PASSWORD))
            return new ResponseEntity<>("Wrong password", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>("Successful login", HttpStatus.OK);
    }

    @Override
    @PostMapping("register/")
    public ResponseEntity<String> register(@RequestBody User user) {
        boolean loginResult = this.userService.register(user);
        if (!loginResult)
            return new ResponseEntity<>("User with this username already exist", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>("User created successfully", HttpStatus.OK);
    }

    @Override
    @GetMapping("gymder/")
    public List<UserGymderData> getUserGymderData(@RequestParam(name = "id") Long id) {
        return this.userService.getUserGymderData(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<Boolean> doesUserExist(@RequestParam(name = "id") Long id) {
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        }
        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.OK);

    }


}
