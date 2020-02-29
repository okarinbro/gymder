package com.white_wolf.threeeyedcrows.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController("/api/info")
public interface IInfoController {
    String getInfo();
}
