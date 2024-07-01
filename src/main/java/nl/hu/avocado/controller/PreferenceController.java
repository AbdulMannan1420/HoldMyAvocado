package nl.hu.avocado.controller;

import nl.hu.avocado.controller.dto.PreferenceDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("preference/")
public class PreferenceController {

    @PostMapping(value = "/receive", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String receiveFormData(@ModelAttribute PreferenceDTO preferenceDTO) {
        // dit moet uiteindelijk naar opgeslagen worden in de database om preferences van de gebruiker te bewaren
        System.out.println("FocuspointMailContent preference: " + preferenceDTO.getContentOptions());
        System.out.println("Day preference: " + preferenceDTO.getDayOptions());
        System.out.println("Time preference: " + preferenceDTO.getTimeOptions());
        return "Form data received successfully!";
    }
}
