package com.white_wolf.threeeyedcrows.model;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private Long id;

    private String password;

    private String name;

    private String email;

    private String username;

    private String description;

    private Long elo;
    
    private List<User> friends;
}
