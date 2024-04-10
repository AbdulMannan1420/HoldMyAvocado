package nl.hu.avocado.controller;


import nl.hu.avocado.domain.Report;
import nl.hu.avocado.model.SendHTMLEmailRequest;
import nl.hu.avocado.service.EmailService;
import nl.hu.avocado.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmailRestController {

    @Autowired
    EmailService emailService;


    @Autowired
    private ReportService reportService;

    @PostMapping("/sendHTMLEmail")
    public String sendIntroductionMail(@RequestBody SendHTMLEmailRequest sendHTMLEmailRequest) {
        Report report = reportService.findByEmail(sendHTMLEmailRequest.getEmail());

        if (report == null) {
            return "Report not found";
        }

        emailService.htmlSend(sendHTMLEmailRequest, report);

        return "Message Queued";
    }
}
