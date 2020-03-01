package com.white_wolf.threeeyedcrows.reportsender;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.white_wolf.threeeyedcrows.model.User;
import com.white_wolf.threeeyedcrows.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Sender {
    @Value("${apikey}")
    private String sendGridApiKey;

    private UserRepository userRepository;
    private StatistcsExtractor statistcsExtractor;

    public Sender(UserRepository userRepository, StatistcsExtractor statistcsExtractor) {
        this.userRepository = userRepository;
        this.statistcsExtractor = statistcsExtractor;
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
        Statistics statistics = statistcsExtractor.getStatistics(user.getId());
        String advice = Advisor.getAdvice(statistics, user);
        sendRequest(user, advice);
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

    private Request createRequest(Mail mail) throws IOException {
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.buildPretty());
        return request;
    }

}
