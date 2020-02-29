package com.white_wolf.threeeyedcrows.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "goals")
@Entity
public class Goal {

    private Long id;

    private String name;

    private Long points;
}
