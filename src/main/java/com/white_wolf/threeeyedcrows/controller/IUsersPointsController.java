package com.white_wolf.threeeyedcrows.controller;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IUsersPointsController {
    List<UserOutcome> getUserAndFriendsOutcome(long userId);

    @Component
    @Data
    class UserOutcome {
        private String name;
        private String email;
        private String description;
        private double points;
        private String city;

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setPoints(double points) {
            this.points = points;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "UserOutcome{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", description='" + description + '\'' +
                    ", points=" + points +
                    ", city='" + city + '\'' +
                    '}';
        }
    }
}
