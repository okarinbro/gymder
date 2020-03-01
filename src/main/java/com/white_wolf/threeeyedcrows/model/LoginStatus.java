package com.white_wolf.threeeyedcrows.model;

import lombok.Data;

@Data
public class LoginStatus {
    public enum Status { WRONG_USER, WRONG_PASSWORD, OK }

    private Status status;

    private Long id;
}
