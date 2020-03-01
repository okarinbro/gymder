package com.white_wolf.threeeyedcrows.reportsender;

import com.white_wolf.threeeyedcrows.model.DailyReport;
import com.white_wolf.threeeyedcrows.model.UserGoal;
import com.white_wolf.threeeyedcrows.repository.DailyReportRepository;
import com.white_wolf.threeeyedcrows.repository.UserGoalRepository;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class StatistcsExtractor {

    private DailyReportRepository reportRepository;
    private UserGoalRepository userGoalRepository;

    public StatistcsExtractor(DailyReportRepository reportRepository, UserGoalRepository userGoalRepository) {
        this.reportRepository = reportRepository;
        this.userGoalRepository = userGoalRepository;
    }

    public Statistics getStatistics(Long id) {
        Timestamp weekAgo = getWeekAgoTimeStamp();
        //todo -> instead of filter use appropriate query :P
        List<DailyReport> reports = reportRepository.findAllById(id)
                .stream()
                .filter(dailyReport -> dailyReport.getTimestamp().after(weekAgo))
                .collect(Collectors.toList());
        double averageWaterConsumption = getAverage(reports, DailyReport::getWaterDrank);
        double averageCalories = getAverage(reports, DailyReport::getCalories);
        double averageSteps = getAverage(reports, DailyReport::getSteps);
        List<UserGoal> userGoals = userGoalRepository.getUserGoals(id);
        long done = userGoals.stream().filter(UserGoal::isCompleted).count();
        double goalsPercent;
        if (userGoals.size() == 0) {
            goalsPercent = 0;
        } else {
            goalsPercent = done / userGoals.size();
        }
        return new Statistics(averageWaterConsumption, averageCalories, averageSteps, goalsPercent);
    }

    private Timestamp getWeekAgoTimeStamp() {
        LocalDate localDate = LocalDate.now().minusDays(7);
        Date date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        long time = date.getTime();
        return new Timestamp(time);
    }

    private double getAverage(List<DailyReport> reports, Function<DailyReport, Long> getData) {
        return reports.stream()
                .map(getData)
                .mapToLong(Long::longValue).average().getAsDouble();
    }
}
