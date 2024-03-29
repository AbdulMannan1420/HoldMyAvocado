package nl.hu.avocado.Presentation;// EmailController.java

import nl.hu.avocado.Service.IntroductionMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private IntroductionMail emailService;

    @GetMapping("/sendEmail")
    public String sendEmail(@RequestBody dtoMail dtoMail) {
        System.out.println("Sending email to: " + dtoMail.to);
        System.out.println("Subject: " + dtoMail.subject);
        emailService.sendHtmlEmail(dtoMail.to, dtoMail.subject);
        return "Email sent successfully!";
    }

    @GetMapping("/test")
    public dtoMail test() {
        dtoMail dtoMail = new dtoMail();
        dtoMail.to = "test.test@testmail.com";
        dtoMail.subject = "Test subject";
        return dtoMail;
    }
}