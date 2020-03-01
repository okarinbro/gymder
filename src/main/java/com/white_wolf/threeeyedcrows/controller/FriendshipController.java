package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.model.User;
import com.white_wolf.threeeyedcrows.service.FriendshipService;
import com.white_wolf.threeeyedcrows.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/friendship/")
public class FriendshipController implements IFriendshipController {
    private FriendshipService friendshipService;
    private UserService userService;

    public FriendshipController(FriendshipService friendshipService, UserService userService) {
        this.friendshipService = friendshipService;
        this.userService = userService;
    }

    @Override
    @PostMapping
    public void addFriendship(@RequestParam(name = "firstUser") long firstUser, @RequestParam(name = "secondUser") String friendUsername) {
        Optional<User> optionalFirstUser = userService.getUser(firstUser);
        Optional<User> optionalSecondUser = userService.getUserByUserName(friendUsername);
        if (optionalFirstUser.isPresent() && optionalSecondUser.isPresent()) {
            User secondUserObject = optionalFirstUser.get();
            User firstUserObject = userService.getUser(firstUser).get();
            friendshipService.addNewFriendship(firstUserObject, secondUserObject);
        } else {
            System.out.println(String.format("Couldn't find users: %d, %d", firstUser, friendUsername));
        }

    }
}
