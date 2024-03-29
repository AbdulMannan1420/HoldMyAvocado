package nl.hu.avocado.Service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class IntroductionMail {

    @Autowired
    private JavaMailSender emailSender;

    public void sendHtmlEmail(String to, String subject) {
        String htmlBody = """
                    <!doctype html>
                    <html ⚡4email lang="en" data-css-strict>
                                 
                    <head>
                        <meta charset="utf-8">
                        <script async src="https://cdn.ampproject.org/v0.js"></script>
                        <style amp4email-boilerplate>body{visibility:hidden}</style>
                        <style amp-custom>
                            * {
                                box-sizing: border-box;
                            }
                                 
                            body {
                                background-color: white;
                                display: grid;
                                margin: 0;
                                height: 4000px;
                                grid-template: repeat(20, 1fr) / repeat(10, 1fr);
                                overflow: scroll;
                            }
                                 
                            .progressie-bar {
                                grid-area: 1 / 1 / 3 / 11;
                                border: 1px solid white;
                                display: flex;
                                justify-content: center;
                                align-items: center;
                                border: 1px solid black;
                            }
                                 
                            .intro-tekst {
                                grid-area: 3 / 1 / 7 / 11;
                                border: 1px solid white;
                                display: flex;
                                justify-content: center;
                                align-items: center;
                                margin: 0;
                                border: 1px solid black;
                            }
                                 
                            .rapport-samenvatting {
                                grid-area: 7 / 1 / 13 / 11;
                                border: 1px solid white;
                                display: flex;
                                justify-content: center;
                                align-items: center;
                                margin: 0;
                                border: 1px solid black;
                            }
                        </style>
                    </head>
                                 
                    <body>
                    <div class="progressie-bar">
                        <h1> Progressie bar</h1>
                    </div>
                    <div class="intro-tekst">
                        <h1> Introtekst</h1>
                    </div>
                    <div class="rapport-samenvatting">
                        <h1> Rapport Samenvatting</h1>
                    </div>
                    </body>
                                 
                    </html>
                   
              
                """;
        MimeMessage message = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlBody, true); // true indicates html

            emailSender.send(message);
        } catch (MessagingException e) {
            // Handle exception appropriately
            e.printStackTrace();
        }
    }
}