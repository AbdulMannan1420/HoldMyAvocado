package nl.hu.avocado.service;


import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import nl.hu.avocado.domain.Report;
import nl.hu.avocado.domain.User;
import nl.hu.avocado.model.SendHTMLEmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class EmailService {

    @Autowired(required = false)
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Value("${fromEmail}")
    private String fromEmail;

    @Value("${fromName}")
    private String fromName;

    @Async
    public void htmlSend(SendHTMLEmailRequest sendHTMLEmailRequest, Report report, User user) {


        try {
            MimeMessage message = emailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(fromEmail, fromName);
            helper.setTo(sendHTMLEmailRequest.getEmail());
            helper.setSubject(sendHTMLEmailRequest.getSubject());


            // Thymeleaf Context
            Context context = new Context();
            Map<String, Object> properties = new HashMap<String, Object>();


            // previous chosen focuspoint for mail 6
            if (user.getReports().size() > 1) {


                properties.put("prevChosenFocuspointName", user.getPreviousChosenFocuspoint().getName());
                properties.put("prevChosenFocuspointLogo", user.getPreviousChosenFocuspoint().getLogo());
                properties.put("prevChosenFocuspointGrowth", user.calculateFocuspointGrowth());
                properties.put("currentChosenFocuspointProgress", user.getCurrentProgressOfPreviousChosenFocuspoint().getProgress());
            }
            // user details
            properties.put("email", user.getEmail());
            properties.put("name", user.getVoornaam());
            // lowest
            properties.put("lowestFocuspointName", report.getLowestFocuspoint().getName());
            properties.put("lowestFocuspointProgress", report.getLowestFocuspoint().getProgress());
            properties.put("lowestFocuspointAdvies", report.getLowestFocuspoint().getAdvies());
            properties.put("lowestFocuspointLogo", report.getLowestFocuspoint().getLogo());
            properties.put("lowestFocuspointID", report.getLowestFocuspoint().getId());
            // second lowest
            properties.put("secondLowestFocuspointName", report.focuspointsSortedByProgressAsc().get(1).getName());
            properties.put("secondLowestFocuspointLogo", report.focuspointsSortedByProgressAsc().get(1).getLogo());
            properties.put("secondlowestFocuspointID", report.focuspointsSortedByProgressAsc().get(1).getId());
            // third lowest
            properties.put("thirdLowestFocuspointName", report.focuspointsSortedByProgressAsc().get(2).getName());
            properties.put("thirdLowestFocuspointLogo", report.focuspointsSortedByProgressAsc().get(2).getLogo());
            properties.put("thirdlowestFocuspointID", report.focuspointsSortedByProgressAsc().get(2).getId());
            // fourth lowest
            properties.put("fourthLowestFocuspointName", report.focuspointsSortedByProgressAsc().get(3).getName());
            properties.put("fourthLowestFocuspointLogo", report.focuspointsSortedByProgressAsc().get(3).getLogo());
            properties.put("fourthlowestFocuspointID", report.focuspointsSortedByProgressAsc().get(3).getId());
            // chosen focuspoint
            properties.put("chosenFocuspointName", report.getChosenFocuspoint().getName());
            properties.put("chosenFocuspointLogo", report.getChosenFocuspoint().getLogo());
            properties.put("chosenFocuspointAdvies", report.getChosenFocuspoint().getAdvies());
            properties.put("chosenFocuspointProgress", report.getChosenFocuspoint().getProgress());

            context.setVariables(properties);


            String html = templateEngine.process("emails/" + sendHTMLEmailRequest.getTemplateName(), context);


            helper.setText(html, true);

            emailSender.send(message);
            log.info("simpleSend: Email Queued");

        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        }

    }
}
