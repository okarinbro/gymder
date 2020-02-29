package com.white_wolf.threeeyedcrows.controller;

import com.white_wolf.threeeyedcrows.model.DailyReport;
import com.white_wolf.threeeyedcrows.service.IReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/report")
public class ReportController implements IReportController {

    private IReportService reportService;

    public ReportController(IReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    @PutMapping
    public void addReport(@RequestBody DailyReport dailyReport) {
        this.reportService.addReport(dailyReport);
    }

}
