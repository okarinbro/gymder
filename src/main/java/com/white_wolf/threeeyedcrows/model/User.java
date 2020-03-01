package com.white_wolf.threeeyedcrows.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String password;

    private String name;

    private String email;

    private String username;

    private String description;

    private String city;

    private Long elo;

    private String pictureLink;

    private int year;

    private int weight;

}
