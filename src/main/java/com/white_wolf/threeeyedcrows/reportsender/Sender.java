package com.white_wolf.threeeyedcrows.reportsender;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.white_wolf.threeeyedcrows.model.DailyReport;
import com.white_wolf.threeeyedcrows.model.User;
import com.white_wolf.threeeyedcrows.model.UserGoal;
import com.white_wolf.threeeyedcrows.repository.DailyReportRepository;
import com.white_wolf.threeeyedcrows.repository.UserGoalRepository;
import com.white_wolf.threeeyedcrows.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class Sender {
    @Value("${apikey}")
    private String sendGridApiKey;
    private DailyReportRepository reportRepository;
    private UserGoalRepository userGoalRepository;
    private UserRepository userRepository;

    public Sender(DailyReportRepository reportRepository, UserGoalRepository userGoalRepository, UserRepository userRepository) {
        this.reportRepository = reportRepository;
        this.userGoalRepository = userGoalRepository;
        this.userRepository = userRepository;
    }

    public void send() throws IOException, InterruptedException {
        while (true) {
            for (User user : userRepository.findAll()) {
                sendReportToUser(user);
            }
            Thread.sleep(1000 * 60 * 60 * 24 * 7);
        }
    }

    public void send(long userId) throws IOException {
        sendReportToUser(userRepository.getOne(userId));
    }

    private void sendReportToUser(User user) throws IOException {
        Statistics statistics = getStatistics(user.getId());
        String advice = Advisor.getAdvice(statistics.getAverageWaterConsumptiondouble(),
                statistics.getAverageSteps(), statistics.getAverageCalories(), statistics.getGoalsCompleted());
        sendRequest(user, advice);
    }

    private Statistics getStatistics(Long id) {
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
        double goalsPercent = done / userGoals.size();
        return new Statistics(averageWaterConsumption, averageCalories, averageSteps, goalsPercent);
    }

    private void sendRequest(User user, String advice) throws IOException {
        SendGrid sg = new SendGrid(sendGridApiKey);
        Email from = new Email("gymder@whitewolf.com");
        Email userEmail = new Email(user.getEmail());
        String subject = "Week report";
        Content content = new Content("text/plain", advice);
        Mail mail = new Mail(from, subject, userEmail, content);
        Request request = createRequest(mail);
        System.out.println("I would sent mail!!!!! ****************************");
        System.out.println(userEmail.getEmail());
        Response api = sg.api(request);
        System.out.println(sendGridApiKey);
        System.out.println(api.getStatusCode());
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

    private Request createRequest(Mail mail) throws IOException {
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.buildPretty());
        return request;
    }

}
