package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.model.Friendship;
import com.white_wolf.threeeyedcrows.model.User;
import com.white_wolf.threeeyedcrows.reportsender.Advisor;
import com.white_wolf.threeeyedcrows.reportsender.StatistcsExtractor;
import com.white_wolf.threeeyedcrows.reportsender.Statistics;
import com.white_wolf.threeeyedcrows.repository.FriendshipRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user/friends/")
public class UsersPointsController implements IUsersPointsController {

    private FriendshipRepository friendshipRepository;
    private StatistcsExtractor statistcsExtractor;

    public UsersPointsController(FriendshipRepository friendshipRepository, StatistcsExtractor statistcsExtractor) {
        this.friendshipRepository = friendshipRepository;
        this.statistcsExtractor = statistcsExtractor;
    }

    @Override
    @GetMapping
    public List<UserOutcome> getUserAndFriendsOutcome(@RequestParam(name = "id") long userId) {
        List<UserOutcome> collect = friendshipRepository.findFriendsByUserId(userId)
                .stream()
                .map(Friendship::getFriend)
                .map(this::getUserOutcome)
                .sorted((o1, o2) -> (int) (o2.getPoints() - o1.getPoints()))
                .collect(Collectors.toList());
        System.out.println(collect);
        return collect;
    }

    private UserOutcome getUserOutcome(User user) {
        UserOutcome userOutcome = new UserOutcome();
        userOutcome.setName(user.getName());
        userOutcome.setEmail(user.getEmail());
        userOutcome.setDescription(user.getDescription());
        userOutcome.setPoints(countPoints(user));
        userOutcome.setCity(user.getCity());
        return userOutcome;
    }

    private double countPoints(User user) {
        Statistics statistics = statistcsExtractor.getStatistics(user.getId());
        return Advisor.getPoints(statistics, user);
    }
}
