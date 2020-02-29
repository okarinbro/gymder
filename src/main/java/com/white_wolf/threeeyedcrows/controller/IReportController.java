package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.model.DailyReport;
import org.springframework.web.bind.annotation.RestController;

public interface IReportController {
    void addReport(DailyReport dailyReport);
}
