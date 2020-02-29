package com.white_wolf.threeeyedcrows.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Table;

@Data
@EnableAutoConfiguration
@Table(name = "goals")
public class Goal {

    private Long id;

    private String name;

    private Long points;
}
