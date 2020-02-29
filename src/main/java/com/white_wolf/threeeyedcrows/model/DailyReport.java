package com.white_wolf.threeeyedcrows.model;

import lombok.Data;

import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Table(name = "daily_reports")
public class DailyReport {

    private Long id;

    private Timestamp timestamp;

    private Long waterDrank;

    private Long calories;

    private Long steps;
}
