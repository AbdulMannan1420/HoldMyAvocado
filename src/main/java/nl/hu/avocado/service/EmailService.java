package nl.hu.avocado.service;


import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import nl.hu.avocado.model.SendHTMLEmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;


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
    public void htmlSend(SendHTMLEmailRequest sendHTMLEmailRequest) {


        try {
            MimeMessage message = emailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(fromEmail, fromName);
            helper.setTo(sendHTMLEmailRequest.getEmail());
            helper.setSubject(sendHTMLEmailRequest.getSubject());


            // Thymeleaf Context
            Context context = new Context();

            String html = templateEngine.process("emails/" + sendHTMLEmailRequest.getTemplateName(), context);


            helper.setText(html, true);

            emailSender.send(message);
            log.info("simpleSend: Email Queued");

        }
        catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        }

    }
}