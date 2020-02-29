package com.white_wolf.threeeyedcrows.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long points;
}
