package nl.hu.avocado.controller;



import nl.hu.avocado.model.SendHTMLEmailRequest;
import nl.hu.avocado.service.EmailService;
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


    @PostMapping("/sendHTMLEmail")
    public String sendHTMLEmail(@RequestBody SendHTMLEmailRequest sendHTMLEmailRequest) {

        emailService.htmlSend(sendHTMLEmailRequest);

        return "Message Queued";
    }

}
