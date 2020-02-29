package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.model.DailyReport;
import com.white_wolf.threeeyedcrows.repository.DailyReportRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import static java.util.Calendar.DATE;

@Service
public class ReportService implements IReportService {

    private DailyReportRepository dailyReportRepository;

    public ReportService(DailyReportRepository dailyReportRepository) {
        this.dailyReportRepository = dailyReportRepository;
    }

    @Override
    public void addReport(DailyReport dailyReport) {
        deleteUsersDayReport(dailyReport.getTimestamp(), dailyReport.getUser().getId());
        this.dailyReportRepository.save(dailyReport);
    }

    public void deleteUsersDayReport(Timestamp timestamp, Long userId){
        List<DailyReport> dailyReportList = this.dailyReportRepository.findAllById(userId);
        Iterator<DailyReport> itDailyReport = dailyReportList.iterator();
        long time = timestamp.getTime();
        Calendar calNewReport = Calendar.getInstance();
        calNewReport.setTimeInMillis(time);
        Integer dayNewReport = calNewReport.get(Calendar.DAY_OF_MONTH);
        Integer monthNewReport = calNewReport.get(Calendar.MONTH);
        Integer yearNewReport = calNewReport.get(Calendar.YEAR);

        Calendar cal = Calendar.getInstance();
        while(itDailyReport.hasNext()){
            DailyReport dailyReport = itDailyReport.next();
            cal.setTimeInMillis(dailyReport.getTimestamp().getTime());
            Integer dayOldReport = cal.get(Calendar.DAY_OF_MONTH);
            Integer monthOldReport = cal.get(Calendar.MONTH);
            Integer yearOldReport = cal.get(Calendar.YEAR);
            if(dayOldReport.equals(dayNewReport) && monthOldReport.equals(monthNewReport)
                    && yearOldReport.equals(yearNewReport))
                this.dailyReportRepository.delete(dailyReport);
        }
    }
}
