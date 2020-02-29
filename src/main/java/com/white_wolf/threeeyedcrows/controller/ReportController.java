package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.model.DailyReport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/reports")
public class ReportController implements IReportController {
    @Override
    @PutMapping
    public void addReport(DailyReport dailyReport) {

    }

}
