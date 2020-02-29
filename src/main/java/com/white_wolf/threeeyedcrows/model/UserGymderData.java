package com.white_wolf.threeeyedcrows.model;

import lombok.Data;

@Data
public class UserGymderData {
    private Long id;
    private String name;
    private String description;
    private String pictureLink;

    public UserGymderData(Long id, String name, String description, String pictureLink) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pictureLink = pictureLink;
    }
}
