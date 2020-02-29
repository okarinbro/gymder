package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.reportsender.Sender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/user/sendmail/")
public class EmailReportController implements IEmailReportController {
    private Sender sender;

    public EmailReportController(Sender sender) {
        this.sender = sender;
    }

    @Override
    @PostMapping
    public void sendEmail(@RequestParam("id") long userId) {
        try {
            sender.send(userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
