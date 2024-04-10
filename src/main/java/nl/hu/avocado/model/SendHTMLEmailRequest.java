package nl.hu.avocado.model;

import lombok.Data;

@Data
public class SendHTMLEmailRequest {
    private String email;
    private String subject;
    private String name;
    private String templateName;
}
