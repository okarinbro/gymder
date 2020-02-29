package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.model.DailyReport;
import com.white_wolf.threeeyedcrows.repository.DailyReportRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ReportService implements IReportService {

    private DailyReportRepository dailyReportRepository;

    public ReportService(DailyReportRepository dailyReportRepository) {
        this.dailyReportRepository = dailyReportRepository;
    }

    @Override
    public void addReport(DailyReport dailyReport) {
        deleteUsersDaysReport(dailyReport.getTimestamp(), dailyReport.getId());
        this.dailyReportRepository.save(dailyReport);
    }

    public void deleteUsersDaysReport(Timestamp timeStamp, Long userId){

    }
}
