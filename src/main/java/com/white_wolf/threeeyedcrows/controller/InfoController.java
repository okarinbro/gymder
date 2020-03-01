package com.white_wolf.threeeyedcrows.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info/")
public class InfoController implements IInfoController {

    @Override
    @GetMapping
    public String getInfo() {
        return "Let me guess.. You really really want to start working out but you have no motivation \n" +
                ".. or maybe you don't have mates willing to start with you? \n" + "" +
                "Let me introduce Gymder! It's simple app that let you meet people from your city \n" +
                "who are in the same situation! You can invite them and ask for jogging, squash or..\n" +
                "who knows ;) You can also keep track of your friends achievements! \n\n" +
                "All you have to do is write your daily report and you will get week summary at your email!\n" +
                "Outcomes are cleared every week so you don't have to worry about that \n" +
                "your friends have much more points than you ;) \n\n" +
                "Take care of your health, you are amazing!";
    }
}
