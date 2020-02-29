package com.white_wolf.threeeyedcrows;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.white_wolf.threeeyedcrows.model"})
public class ThreeEyedCrowsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreeEyedCrowsApplication.class, args);
    }

}
