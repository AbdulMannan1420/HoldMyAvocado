package nl.hu.avocado.controller;


import nl.hu.avocado.domain.Report;
import nl.hu.avocado.domain.User;
import nl.hu.avocado.model.SendHTMLEmailRequest;
import nl.hu.avocado.service.EmailService;
import nl.hu.avocado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmailRestController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;


    @PostMapping("/sendHTMLEmail")
    public String sendMail(@RequestBody SendHTMLEmailRequest sendHTMLEmailRequest) {
        User user = userService.findUserByEmail(sendHTMLEmailRequest.getEmail());
        Report report = user.getLastReport();

        if (report == null) {
            return "Report not found";
        }

        emailService.htmlSend(sendHTMLEmailRequest, report, user);

        return "Message Queued";
    }
}
