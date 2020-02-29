package com.white_wolf.threeeyedcrows.model;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "goals")
public class Goal {

    private Long id;

    private String name;

    private Long points;
}
